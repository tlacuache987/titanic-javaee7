package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.datasource.DataSourceBoleto;
import com.titanic.ventapasajes.datasource.ReporteGen;
import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroVentaService;
import com.titanic.ventapasajes.service.TarifaGeneralService;
import com.titanic.ventapasajes.util.FacesUtil;
import com.titanic.ventapasajes.util.reporte.EjecutorReporte;

import org.apache.commons.lang.StringEscapeUtils;
import org.hibernate.Session;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

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
    private TarifaGeneralService tarifaGeneralService;

    @Inject
    private Seguridad seguridad;

    @Inject
    private FacesContext facesContext;
    @Inject
    private HttpServletResponse response;
    @Inject
    private EntityManager entityManager;

    @NotNull
    private Date fechaVenta;
    private Recorrido ruta;
    private String horaSalida;
    private Bus bus;
    private String nombreBus;
    private boolean cargarAsientos;
    private Venta venta;
    private List<Boleto> boletos;
    private String nameDocumentPDF;

    private DataSourceBoleto dt;




    public boolean isCargarAsientos() {
        return (this.fechaVenta != null && this.ruta != null && this.horaSalida != null && this.bus != null);
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


    public Sexo[] getSexo() {
        return Sexo.values();
    }

    public List<Boleto> getBoletos() {
        return boletos;
    }

    public void setBoletos(List<Boleto> boletos) {
        this.boletos = boletos;
    }


    private void nuevaVenta() {
        venta = new Venta();
        venta.setFechaVenta(fechaVenta);
        venta.setRuta(ruta);
        venta.setHoraSalida(horaSalida);
        venta.setBus(bus);
        venta.setTotalVenta(BigDecimal.ZERO);
        boletos = new ArrayList<>();

        for(FilaSuperior filaSuperior: bus.getFilasSuperiores()){
            for(CeldaSuperior celdaSuperior: filaSuperior.getCeldasSuperiores()){

                Boleto boleto = new Boleto();
                boleto.setAsiento(celdaSuperior.getNumeroAsiento());
                boleto.setOrigen(ruta.getOrigen().getNombreTerminal());
                boleto.setDestino(ruta.getDestino().getNombreTerminal());
                boleto.setEstadoBoleto(celdaSuperior.getEstadoCelda());
                SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
                boleto.setFechaVenta(DATE_FORMAT.format(fechaVenta));
                boleto.setHoraSalida(horaSalida);
                boleto.setUsuario(seguridad.getUsuarioLogeado().getUsuario());
                TarifaGeneral tarifaGeneral = tarifaGeneralService.buscarTarifaGeneral(celdaSuperior.getCalidad().getDescripcion(), ruta.getIdeRecorrido());
                boleto.setPrecio(tarifaGeneral.getPrecio());

                boletos.add(boleto);

            }
        }


        venta.setBoletos(boletos);
        ventaService.registrarVenta(venta);

        FacesUtil.adicionarMensajeInfo("Se inicializo venta satisfactoriamente");
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

        venta = ventaService.obtenerVenta(fechaVenta, ruta, horaSalida, bus);

        if (venta == null)
            nuevaVenta();

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus Seleccionado", "Id:" + busSeleccionado.getDescripcionBus());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public String onFlowProcess(FlowEvent event) {


        return event.getNewStep();

    }


}
