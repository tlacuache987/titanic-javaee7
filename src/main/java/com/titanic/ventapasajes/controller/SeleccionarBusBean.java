package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@ViewScoped
public class SeleccionarBusBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @NotNull
    private Date fechaVenta = new Date();


    @Inject
    private ProgramacionRepositorio programacionRepositorio;




    private List<Programacion> programaciones;



    private void inicializar() {
        ProgramacionFiltros filtros = new ProgramacionFiltros();
        filtros.setFechaProgramacion(fechaVenta);
        this.programaciones = programacionRepositorio.listarProgramacionesFiltradas(filtros);
    }



    public void onFechaSeleccionada(SelectEvent event) {
        Date nuevaFecha = (Date) event.getObject();

        this.setFechaVenta(nuevaFecha);


        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Modificada", "Fecha Venta:" + fechaVenta);

        FacesContext.getCurrentInstance().addMessage(null, message);
    }



    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }


    public List<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(List<Programacion> programaciones) {
        this.programaciones = programaciones;
    }
}
