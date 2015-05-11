package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroVentaService;
import org.apache.commons.lang.StringEscapeUtils;
import org.primefaces.event.CellEditEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@RequestScoped
public class SeleccionarAsientosBean implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private RegistroVentaService ventaService;

    @Inject
    private ProgramacionRepositorio programacionRepositorio;

    @Inject
    private HttpServletRequest request;

    @Inject
    private Seguridad seguridad;


    private Programacion programacion;

    private Venta venta;


    @PostConstruct
    public void init(){

        String programacionReq = request.getParameter("programacion");

        String programacionId = null;

        if(programacionReq!=null) {
            request.getSession().setAttribute("programacionId", programacionReq);
            programacionId = programacionReq;
        }else{
            programacionId = (String) request.getSession().getAttribute("programacionId");
        }

        programacion = programacionRepositorio.obtenerProgramacion(Long.valueOf(programacionId));


        venta = ventaService.obtenerVenta(programacion);
        if(venta==null){
            nuevaVenta();
        }
    }



    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }



    private void nuevaVenta() {

        try{

            venta = new Venta();
            venta.setProgramacion(programacion);
            venta.setTotalVenta(BigDecimal.ZERO);

            List<FilaBoletoSuperior> filasBoletosSuperiores = new ArrayList<>();
            List<FilaBoletoInferior> filasBoletosInferiores = new ArrayList<>();

            venta.setFilasBoletoSuperiores(clonarFilasSuperiores(filasBoletosSuperiores));
            venta.setFilasBoletosInferiores(clonarFilasInferiores(filasBoletosInferiores));

            ventaService.registrarVenta(venta);
        }catch(Exception ex){

            venta.setFilasBoletosInferiores(new ArrayList<FilaBoletoInferior>());
            venta.setFilasBoletoSuperiores(new ArrayList<FilaBoletoSuperior>());

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Nueva Venta", "No se pudo crear la venta. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);

        }


    }

    private List<FilaBoletoInferior> clonarFilasInferiores(List<FilaBoletoInferior> filasBoletosInferiores) {

        for(Fila fila: programacion.getBus().getFilasInferiores()){

            FilaBoletoInferior filaBoletoInferior = new FilaBoletoInferior();
            filaBoletoInferior.setUbicacionPlanta(fila.getUbicacionPlanta());
            filaBoletoInferior.setVenta(venta);
            filaBoletoInferior.setBoletosInferiores(new ArrayList<BoletoInferior>());

            for(Celda celdaInferior: fila.getCeldasInferiores()){

                BoletoInferior boletoInferior = new BoletoInferior();
                boletoInferior.setCalidad(celdaInferior.getCalidad());
                boletoInferior.setEstadoBoleto(celdaInferior.getEstadoCelda());
                boletoInferior.setFilaBoletoInferior(filaBoletoInferior);
                boletoInferior.setNumeroAsiento(celdaInferior.getNumeroAsiento());
                boletoInferior.setNumeroBoleto(celdaInferior.getNumeroCelda());
                boletoInferior.setTipoBoleto(celdaInferior.getTipoCelda());
                boletoInferior.setPrecio(BigDecimal.ZERO);
                setPrecioBoleto(boletoInferior);
                boletoInferior.setOrigen(programacion.getRuta().getOrigen().getNombreTerminal());
                boletoInferior.setDestino(programacion.getRuta().getDestino().getNombreTerminal());
                filaBoletoInferior.getBoletosInferiores().add(boletoInferior);
            }

            filasBoletosInferiores.add(filaBoletoInferior);
        }

        return filasBoletosInferiores;
    }

    private void setPrecioBoleto(BoletoInferior boletoInferior) {
        Recorrido ruta = programacion.getRuta();
        for(TarifaGeneral tarifaGeneral: ruta.getPrecios()){
            if(tarifaGeneral.getTipoBus().equals(boletoInferior.getCalidad())){
                boletoInferior.setPrecio(tarifaGeneral.getPrecio());
                break;
            }
        }
    }

    private void setPrecioBoleto(BoletoSuperior boletoSuperior) {
        Recorrido ruta = programacion.getRuta();
        for(TarifaGeneral tarifaGeneral: ruta.getPrecios()){
            if(tarifaGeneral.getTipoBus().equals(boletoSuperior.getCalidad())){
                boletoSuperior.setPrecio(tarifaGeneral.getPrecio());
                break;
            }
        }
    }

    private List<FilaBoletoSuperior> clonarFilasSuperiores(List<FilaBoletoSuperior> filasBoletosSuperiores) {

        for(FilaSuperior filaSuperior: programacion.getBus().getFilasSuperiores()){

            FilaBoletoSuperior filaBoletoSuperior = new FilaBoletoSuperior();
            filaBoletoSuperior.setUbicacionPlanta(filaSuperior.getUbicacionPlanta());
            filaBoletoSuperior.setVenta(venta);
            filaBoletoSuperior.setBoletosSuperiores(new ArrayList<BoletoSuperior>());

            for(CeldaSuperior celdaSuperior: filaSuperior.getCeldasSuperiores()){

                BoletoSuperior boletoSuperior = new BoletoSuperior();
                boletoSuperior.setCalidad(celdaSuperior.getCalidad());
                boletoSuperior.setEstadoBoleto(celdaSuperior.getEstadoCelda());
                boletoSuperior.setFilaBoletoSuperior(filaBoletoSuperior);
                boletoSuperior.setNumeroAsiento(celdaSuperior.getNumeroAsiento());
                boletoSuperior.setNumeroBoleto(celdaSuperior.getNumeroCelda());
                boletoSuperior.setTipoBoleto(celdaSuperior.getTipoCelda());
                boletoSuperior.setPrecio(BigDecimal.ZERO);
                setPrecioBoleto(boletoSuperior);
                filaBoletoSuperior.getBoletosSuperiores().add(boletoSuperior);

            }

            filasBoletosSuperiores.add(filaBoletoSuperior);
        }

        return filasBoletosSuperiores;
    }


    public void notificarPUSH() {
        String summary = "Reservar Reservado";
        String detail = "Nuevo asiento reservado";
        String CHANNEL = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL,
                new FacesMessage(StringEscapeUtils.escapeHtml(summary), StringEscapeUtils.escapeHtml(detail)));
    }

    public void reservar(BoletoInferior boletoInferior){

        try{

            if(boletoInferior.getEstadoBoleto() == EstadoBoleto.LIBRE){
                boletoInferior.setEstadoBoleto(EstadoBoleto.RESERVADO);
            }else if(boletoInferior.getEstadoBoleto()==EstadoBoleto.RESERVADO){
                boletoInferior.setEstadoBoleto(EstadoBoleto.LIBRE);
            }else if(boletoInferior.getEstadoBoleto()==EstadoBoleto.PAGADO){
                boletoInferior.setEstadoBoleto(EstadoBoleto.LIBRE);
                actualizarTotalVenta();
            }


            boletoInferior.setUsuario(seguridad.getUsuarioLogeado().getUsuario());

            this.venta = ventaService.registrarVenta(this.venta);
            notificarPUSH();

        }catch (Exception ex){
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Reservar Boleto", "No se pudo reservar el Boleto. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    public void reservar(BoletoSuperior boletoSuperior){

        try{

            if(boletoSuperior.getEstadoBoleto() == EstadoBoleto.LIBRE){
                boletoSuperior.setEstadoBoleto(EstadoBoleto.RESERVADO);
            }else if(boletoSuperior.getEstadoBoleto()==EstadoBoleto.RESERVADO){
                boletoSuperior.setEstadoBoleto(EstadoBoleto.LIBRE);
            }else if(boletoSuperior.getEstadoBoleto()==EstadoBoleto.PAGADO){
                boletoSuperior.setEstadoBoleto(EstadoBoleto.LIBRE);
                actualizarTotalVenta();
            }


            boletoSuperior.setUsuario(seguridad.getUsuarioLogeado().getUsuario());

            this.venta = ventaService.registrarVenta(this.venta);
            notificarPUSH();

        }catch (Exception ex){
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Reservar Boleto", "No se pudo reservar el Boleto. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }

    private void actualizarTotalVenta() {

        BigDecimal totalVentaPagados = BigDecimal.ZERO;

        for (FilaBoletoSuperior filaBoletoSuperior : venta.getFilasBoletoSuperiores()) {

            for (BoletoSuperior boletoSuperior : filaBoletoSuperior.getBoletosSuperiores()) {

                if (boletoSuperior.getEstadoBoleto() == EstadoBoleto.PAGADO) {
                    totalVentaPagados.add(boletoSuperior.getPrecio());
                }

            }
        }

        for (FilaBoletoInferior filaBoletoInferior : venta.getFilasBoletosInferiores()) {

            for (BoletoInferior boletoInferior : filaBoletoInferior.getBoletosInferiores()) {

                if (boletoInferior.getEstadoBoleto() == EstadoBoleto.PAGADO) {
                    totalVentaPagados.add(boletoInferior.getPrecio());
                }
            }
        }

        venta.setTotalVenta(totalVentaPagados);

    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }


}
