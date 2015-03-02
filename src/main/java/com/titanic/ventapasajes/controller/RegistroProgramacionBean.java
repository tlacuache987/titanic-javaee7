package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.TipoProgramacion;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.service.RegistroProgramacionService;
import com.titanic.ventapasajes.util.FacesUtil;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */

@Named
@ViewScoped
public class RegistroProgramacionBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroProgramacionService programacionService;

    @Inject
    private BusRepositorio busRepositorio;

    private Programacion programacion;



    public RegistroProgramacionBean(){
        programacion = new Programacion();
    }

    public void inicializar(){
        if(!FacesUtil.isPostback()){
            //inicializar listas
        }
    }



    public void registrarProgramacion(){
        this.programacion = programacionService.registrarProgramacion(this.programacion);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("La programación se registro correctamente");
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }



    private void limpiarFormulario(){
        programacion = new Programacion();

    }

    public boolean isEditando(){
        return this.programacion.getIdeProgramacion() !=null;
    }

    public void seleccionarBus() {
        RequestContext.getCurrentInstance().openDialog("seleccionarBus");
    }



    public TipoProgramacion[] getTipoProgramacion() {
        return TipoProgramacion.values();
    }

    public void onBusSeleccionado(SelectEvent event) {
        Bus busSeleccionado = (Bus) event.getObject();

        this.programacion.setBus(busRepositorio.getFilasWithBusById(busSeleccionado.getIdeBus()));
        

        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bus Seleccionado", "Id:" + busSeleccionado.getDescripcionBus());

        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
