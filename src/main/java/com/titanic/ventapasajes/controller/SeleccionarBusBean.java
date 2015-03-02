package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.Recorrido;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@ViewScoped
public class SeleccionarBusBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private Date fechaVenta;

    @NotNull
    private Date nuevaFechaVenta;


    @NotNull
    private Recorrido ruta;


    private boolean mostrarParametros = false;


    public void modificarParametros() {
        this.mostrarParametros = !mostrarParametros;
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

    public void onFechaSeleccionada(SelectEvent event) {
        Date nuevaFecha = (Date) event.getObject();

       this.setFechaVenta(nuevaFecha);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Modificada", "Fecha Venta:" + fechaVenta);

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

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public boolean isMostrarParametros() {
        return mostrarParametros;
    }

    public void setMostrarParametros(boolean mostrarParametros) {
        this.mostrarParametros = mostrarParametros;
    }

    public Date getNuevaFechaVenta() {
        return nuevaFechaVenta;
    }

    public void setNuevaFechaVenta(Date nuevaFechaVenta) {
        this.nuevaFechaVenta = nuevaFechaVenta;

    }
}
