package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.datasource.DataSourceBoleto;
import com.titanic.ventapasajes.datasource.ReporteGen;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroVentaService;
import com.titanic.ventapasajes.util.FacesUtil;
import com.titanic.ventapasajes.util.reporte.EjecutorReporte;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by josediaz on 7/26/14.
 */

@Named
@ViewScoped
public class VentaPasajeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroVentaService ventaService;

    @Inject
    private BusRepositorio busRepositorio;

    @Inject
    private RegistroClienteService clienteService;

    @Inject
    private Seguridad seguridad;

    @Inject private FacesContext facesContext;
    @Inject private HttpServletResponse response;
    @Inject private EntityManager entityManager;

    @NotNull
    private Date fechaVenta;
    private Recorrido ruta;
    private String horaSalida;
    private Bus bus;
    private String nombreBus;
    private boolean cargarAsientos;
    private Venta venta;
    private List<Boleto> boletosReservados;
    private String nameDocumentPDF;

    private DataSourceBoleto dt;

    @PostConstruct
    public void init() {
        iniciarVenta();


    }

    private void iniciarVenta() {
        venta = new Venta();
        boletosReservados = new ArrayList<>();
    }

    public void inicializar() {


        if (isCargarAsientos()) {

            Venta ventaGuardada = ventaService.obtenerVenta(fechaVenta, ruta, horaSalida, bus);
            if (ventaGuardada != null) {
                venta = ventaGuardada;
            } else {
                venta.setFechaVenta(fechaVenta);
                venta.setRuta(ruta);
                venta.setHoraSalida(horaSalida);
                venta.setBus(bus);
                venta.setTotalVenta(BigDecimal.ZERO);
            }

        }


    }


    public void reservar(String numeroAsiento) {

        Boleto boleto = buscarBoleto(numeroAsiento);
        if (boleto == null) {
            boleto = new Boleto();
            boleto.setAsiento(numeroAsiento);
            boleto.setEstadoBoleto(EstadoBoleto.RESERVADO);
            boleto.setPrecio(new BigDecimal("40.00"));
            boleto.setVenta(venta);
            boleto = asociarVendedor(boleto);
            if (venta.getBoletos() == null) {
                venta.setBoletos(new ArrayList<Boleto>());
            }
            //configureClienteForBoleto(boleto);
            venta.getBoletos().add(boleto);

        } else {

            if (boleto.getEstadoBoleto() == EstadoBoleto.LIBRE) {
                boleto.setEstadoBoleto(EstadoBoleto.RESERVADO);
            } else if (boleto.getEstadoBoleto() == EstadoBoleto.RESERVADO) {
                boleto.setEstadoBoleto(EstadoBoleto.LIBRE);
            } else { //pagado
                boleto.setEstadoBoleto(EstadoBoleto.LIBRE);
            }


        }

        registrarVenta();
    }

    private Boleto asociarVendedor(Boleto boleto) {
        Usuario usuario = seguridad.getUsuarioLogeado().getUsuario();
        boleto.setUsuario(usuario);
        return boleto;
    }

    private Boleto buscarBoleto(String numeroAsiento) {
        if (venta.getBoletos() == null) return null;

        for (Boleto boleto : venta.getBoletos()) {
            if (boleto.getAsiento().equals(numeroAsiento)) {
                return boleto;
            }
        }
        return null;
    }

    public String obtenerEstado(String numeroAsiento) {
        if (venta.getBoletos() == null) return String.valueOf(EstadoBoleto.LIBRE);

        Boleto boleto = buscarBoleto(numeroAsiento);

        if (boleto == null) {

            boleto = new Boleto();
            boleto.setAsiento(numeroAsiento);
            boleto.setEstadoBoleto(EstadoBoleto.LIBRE);
            boleto.setPrecio(new BigDecimal("40.00"));
            boleto.setVenta(venta);
            boleto = asociarVendedor(boleto);
            if (venta.getBoletos() == null) {
                venta.setBoletos(new ArrayList<Boleto>());
            }
            //configureClienteForBoleto(boleto);
            venta.getBoletos().add(boleto);



        }else{

            if(boleto.getEstadoBoleto()!= EstadoBoleto.PAGADO) {
                Usuario vendedor = boleto.getUsuario();
                Usuario usuarioLogueado = seguridad.getUsuarioLogeado().getUsuario();
                if (!vendedor.equals(usuarioLogueado)) {
                    boleto.setEstadoBoleto(EstadoBoleto.NO_DISPONIBLE);
                }
            }
        }

        return boleto.getEstadoBoleto().toString();
    }

    private void configureClienteForBoleto(Boleto boleto) {
        boleto.setCliente(new Cliente());
        boleto.getCliente().setEdad(0);
        boleto.getCliente().setSexo(Sexo.FEMENINO);
        boleto.getCliente().setTipoDocumento(TipoDocumento.DNI);
        boleto.getCliente().setTipoPersona(TipoPersona.NATURAL);
        boleto.getCliente().setDebePresentarCartaNotarial(false);
    }

    private void validarFormulario() {
        if (ruta == null) {
            FacesUtil.adicionarMensajeError("Ruta debe ser seleccionada");
        }
        if (bus == null) {
            FacesUtil.adicionarMensajeError("Bus debe ser seleccionado");
        }
    }


    /* UI methods */

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada",
                format.format(event.getObject())));
    }


    public void seleccionarBus() {
        RequestContext.getCurrentInstance().openDialog("seleccionarBus");
    }


    public void seleccionarRuta() {
        RequestContext.getCurrentInstance().openDialog("seleccionarRuta");
    }

    public void onRutaSeleccionada(SelectEvent event) {
        Recorrido recorrido = (Recorrido) event.getObject();

        this.setRuta(recorrido);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ruta Seleccionada", "Id:" + recorrido.getRuta());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onBusSeleccionado(SelectEvent event) {
        Bus busSeleccionado = (Bus) event.getObject();

        this.setBus(busRepositorio.getFilasWithBusById(busSeleccionado.getIdeBus()));
        this.nombreBus = bus.getDescripcionBus();


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus Seleccionado", "Id:" + busSeleccionado.getDescripcionBus());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public String onFlowProcess(FlowEvent event) {

        boletosReservados = new ArrayList<>();

        if(venta.getBoletos()!=null) {
            for (Boleto boleto : venta.getBoletos()) {
                if (boleto.getEstadoBoleto() == EstadoBoleto.RESERVADO) {
                    Cliente cliente = new Cliente();
                    cliente.setEdad(0);
                    cliente.setSexo(Sexo.FEMENINO);
                    cliente.setTipoDocumento(TipoDocumento.DNI);
                    cliente.setTipoPersona(TipoPersona.NATURAL);
                    cliente.setDebePresentarCartaNotarial(false);
                    boleto.setCliente(cliente);
                    boletosReservados.add(boleto);
                }
            }
        }


        return event.getNewStep();

    }


    public void registrarVenta() {


        this.venta = ventaService.registrarVenta(this.venta);

        FacesUtil.adicionarMensajeInfo("Se reservo satisfactoriamente");
    }



    public void registrarVentaConCliente() {

        if(boletosReservados.size()>0) {

            for (int i = 0; i < boletosReservados.size(); i++) {

                Cliente cliente = boletosReservados.get(i).getCliente();
                cliente = clienteService.adicionarCliente(cliente);
                Boleto boleto = buscarBoleto(boletosReservados.get(i).getAsiento());
                boleto.setCliente(cliente);
                boleto.setEstadoBoleto(EstadoBoleto.PAGADO);
                boleto.setNumeroDocumento(cliente.getNumeroDocumento());
                boleto.setNombresCliente(cliente.getNombreCliente());
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
                boleto.setFechaVenta(DATE_FORMAT.format(fechaVenta));
                boleto.setHoraSalida(horaSalida);
                boleto.setOrigen(ruta.getOrigen().getNombreTerminal());
                boleto.setDestino(ruta.getDestino().getNombreTerminal());
                boleto.setPresentoCartaNotarial(boletosReservados.get(i).getPresentoCartaNotarial());
            }

            this.venta.setTotalVenta(getTotalPagados());

            this.venta = ventaService.registrarVenta(this.venta);
            //printSilentPDF();
            FacesUtil.adicionarMensajeInfo("Los boletos fueron vendidos satisfactoriamente");
        }
    }


    public void imprimirVenta(){

        System.out.println("Uno: " + getBoletosReservados().size());
        dt = new DataSourceBoleto();
        for(Boleto boleto: getBoletosReservados()){
            dt.addDetalle(boleto);
        }

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("boletos",  obtenerIdsBoletos().split(",") );


        EjecutorReporte executor = new EjecutorReporte("/reportes/venta_boletos3.jasper",
                this.response, parametros, "venta_boletos_" + this.venta.getIdeVenta() + ".pdf", dt);

        Session session = entityManager.unwrap(Session.class);
        session.doWork(executor);

        if (executor.isReporteGenerado()) {
            facesContext.responseComplete();
        } else {
            FacesUtil.adicionarMensajeError("No hay datos para la venta..");
        }


    }
    
    
    public void printSilentPDF(){
    	System.out.println("Uno: " + getBoletosReservados().size());
        dt = new DataSourceBoleto();   
        for(Boleto boleto: getBoletosReservados()){
            dt.addDetalle(boleto);
        }
        
        //String path="/reportes/venta_boletos2.jasper";           
        String path="/reportes/venta_boleto4.jasper";
        ReporteGen rep = new ReporteGen();
        rep.exportByFormato(dt, path, "pdf", "boleto");
        dt=null;
        
    }

    private String obtenerIdsBoletos() {
        String idsBoletos = "";
        for(Boleto boleto: getBoletosReservados()){
            if(idsBoletos.isEmpty()){
                idsBoletos = String.valueOf(boleto.getIdeBoleto());
            }else{
                idsBoletos = idsBoletos + "," + String.valueOf(boleto.getIdeBoleto());
            }
        }
        return idsBoletos;
    }

    public void nuevaVenta(){
        iniciarVenta();
    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Recorrido getRuta() {
        return ruta;
    }

    public void setRuta(Recorrido ruta) {
        this.ruta = ruta;
    }


    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getNombreBus() {
        return nombreBus;
    }

    public void setNombreBus(String nombreBus) {
        this.nombreBus = nombreBus;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public String getAsientosReservados() {
        String reservados = "";
        if (venta.getBoletos() != null) {
            for (Boleto boleto : venta.getBoletos()) {
                if (reservados.isEmpty() && (boleto.getEstadoBoleto() == EstadoBoleto.RESERVADO)) {
                    reservados = boleto.getAsiento();
                } else if(boleto.getEstadoBoleto() == EstadoBoleto.RESERVADO) {
                    reservados = reservados + "," + boleto.getAsiento();
                }
            }
        }
        return reservados;
    }

    public String getTotalReservados() {

        BigDecimal total = BigDecimal.ZERO;

        if (venta.getBoletos() != null) {
            for (Boleto boleto : venta.getBoletos()) {
                if(boleto.getEstadoBoleto() == EstadoBoleto.RESERVADO) {
                    total = total.add(boleto.getPrecio());
                }
            }
        }

        return total.toString();
    }


    public BigDecimal getTotalPagados() {

        BigDecimal total = BigDecimal.ZERO;

        if (venta.getBoletos() != null) {
            for (Boleto boleto : venta.getBoletos()) {
                if(boleto.getEstadoBoleto() == EstadoBoleto.PAGADO) {
                    total = total.add(boleto.getPrecio());
                }
            }
        }

        return total;
    }

    public boolean isCargarAsientos() {
        return (this.fechaVenta != null && this.ruta != null && this.horaSalida != null && this.bus != null);
    }


    public Sexo[] getSexo() {
        return Sexo.values();
    }

    public List<Boleto> getBoletosReservados() {
        return boletosReservados;
    }

    public void setBoletosReservados(List<Boleto> boletosReservados) {
        this.boletosReservados = boletosReservados;
    }


    public void addMessage(Boleto boleto) {
        String summary = boleto.getPresentoCartaNotarial() ? "Presento Carta Notarial" : "No ha presentado carta notarial";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void validarCartaNotarial(Cliente cliente){
        if(cliente.getEdad()<18){
            cliente.setDebePresentarCartaNotarial(true);
        }else{
            cliente.setDebePresentarCartaNotarial(false);
        }
    }

    public List<String> completeClientes(String query) {
        List<Cliente> todosLosClientes = clienteService.buscarTodos();
        List<String> dnisFiltrados = new ArrayList<>();

        for(Cliente cliente : todosLosClientes){
            if(cliente.getNumeroDocumento().toLowerCase().startsWith(query)){
                dnisFiltrados.add(cliente.getNumeroDocumento());
            }
        }
       return dnisFiltrados;
    }


    public void setearCliente(Cliente cliente){
        if(cliente!=null) {
            Cliente clienteBD = clienteService.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
            cliente.setNumeroDocumento(clienteBD.getNumeroDocumento());
            cliente.setEdad(clienteBD.getEdad());
            cliente.setSexo(clienteBD.getSexo());
            cliente.setNombreCliente(clienteBD.getNombreCliente());
            cliente.setIdeCliente(clienteBD.getIdeCliente());

        }


    }

	public String getNameDocumentPDF() {
		return nameDocumentPDF;
	}

	public void setNameDocumentPDF(String nameDocumentPDF) {
		this.nameDocumentPDF = nameDocumentPDF;
	}



}
