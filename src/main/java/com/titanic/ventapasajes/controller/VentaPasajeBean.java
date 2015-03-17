package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.modelo.Recorrido;
import org.apache.commons.lang.StringEscapeUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by josediaz on 7/26/14.
 */

@Named
@ViewScoped
public class VentaPasajeBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private Recorrido ruta;

    @NotNull
    private Date fechaVenta;





    private void inicializar() {

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


    public Recorrido getRuta() {
        return ruta;
    }

    public void setRuta(Recorrido ruta) {
        this.ruta = ruta;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }

    public String getFechaVentaAsString(){
       return  fechaVenta==null?"":new SimpleDateFormat("yyyyMMddHHmmss").format(fechaVenta);
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public void notificarPUSH() {
        String summary = "Asiento Vendido";
        String detail = "Nuevo asiento vendido";
        String CHANNEL = "/notify";

        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL,
                new FacesMessage(StringEscapeUtils.escapeHtml(summary), StringEscapeUtils.escapeHtml(detail)));

    }
}
