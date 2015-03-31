package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.modelo.Celda;
import com.titanic.ventapasajes.modelo.CeldaSuperior;
import com.titanic.ventapasajes.modelo.EstadoCelda;
import com.titanic.ventapasajes.modelo.Fila;
import com.titanic.ventapasajes.modelo.FilaSuperior;
import com.titanic.ventapasajes.modelo.TipoBus;
import com.titanic.ventapasajes.modelo.TipoCelda;
import com.titanic.ventapasajes.modelo.TipoPlanta;
import com.titanic.ventapasajes.modelo.UbicacionPlanta;
import com.titanic.ventapasajes.service.RegistroBusService;
import com.titanic.ventapasajes.util.FacesUtil;

/**
 * Created by josediaz on 7/20/14.
 */

@Named
@ViewScoped
public class RegistroBusBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroBusService busService;

    private Bus bus;


    public RegistroBusBean() {
        bus = new Bus();

    }

    private List<Fila> getFilasYCeldasInferiores(Bus bus) {
        List<Fila> planta = new ArrayList<>();
        for(int i=0; i<10; i++){
            Fila fila = new Fila();
            fila.setBus(bus);
            fila.setUbicacionPlanta(UbicacionPlanta.INFERIOR);
            fila.setCeldasInferiores(new ArrayList<Celda>());
            for(int j=0; j<5; j++){
                Celda celda = new Celda();
                celda.setNumeroCelda("");
                celda.setEstadoCelda(EstadoCelda.LIBRE);
                celda.setTipoCelda(TipoCelda.OTRO);
                celda.setFila(fila);
                fila.getCeldasInferiores().add(celda);
            }
            planta.add(fila);
        }
        return planta;
    }



    public void inicializar() {
        if (!FacesUtil.isPostback()) {
            if(!isEditando()) {
                bus.setFilasInferiores(getFilasYCeldasInferiores(bus));
                bus.setFilasSuperiores(getFilasYCeldasSuperiores(bus));
            }
        }
    }

    private List<FilaSuperior> getFilasYCeldasSuperiores(Bus bus) {

        List<FilaSuperior> planta = new ArrayList<>();
        for(int i=0; i<15; i++){
            FilaSuperior fila = new FilaSuperior();
            fila.setBus(bus);
            fila.setUbicacionPlanta(UbicacionPlanta.SUPERIOR);
            fila.setCeldasSuperiores(new ArrayList<CeldaSuperior>());
            for(int j=0; j<5; j++){
                CeldaSuperior celda = new CeldaSuperior();
                celda.setNumeroCelda("");
                celda.setEstadoCelda(EstadoCelda.LIBRE);
                celda.setTipoCelda(TipoCelda.OTRO);
                celda.setFila(fila);
                fila.getCeldasSuperiores().add(celda);
            }
            planta.add(fila);
        }
        return planta;
    }

    public Bus getBus() {
        return bus;
    }

    public TipoPlanta[] getTiposPlantas() {
        return TipoPlanta.values();
    }

    public TipoBus[] getTiposBuses() {
        return TipoBus.values();
    }




    public void registrarBus() {
        this.bus = busService.registrarBus(this.bus);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El Bus se registro correctamente");
    }

    private void limpiarFormulario() {
        bus = new Bus();

    }

    public void setBus(Bus bus) {
        this.bus = bus;

    }

    public boolean isEditando() {
        return this.bus.getIdeBus() != null;
    }


    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {

            DataTable table = (DataTable) event.getSource();
            if (table.getRowData() instanceof FilaSuperior){

                FilaSuperior filaSuperior = (FilaSuperior) table.getRowData();
                updateTipoCeldaSuperior(filaSuperior);

            }else{
                Fila filaInferior = (Fila) table.getRowData();
                updateTipoCeldaInferior(filaInferior);
            }

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ubicacion cambiada", "Anterior: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    private void updateTipoCeldaInferior(Fila filaInferior) {
        for(Celda celda: filaInferior.getCeldasInferiores()){
            configurarValoresCelda(celda);
        }

    }

    private void configurarValoresCelda(Celda celda) {
        String numeroCelda = celda.getNumeroCelda().toUpperCase();

        if(numeroCelda.startsWith("O")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.COMUN);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));
        } else if(numeroCelda.startsWith("S")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.SEMI_CAMA);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        } else if(numeroCelda.startsWith("C")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.CAMA);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        } else if(numeroCelda.startsWith("U")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.SUIT);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        }else{
            celda.setTipoCelda(TipoCelda.OTRO);
        }
    }

    private void updateTipoCeldaSuperior(FilaSuperior filaSuperior) {
        for(CeldaSuperior celda: filaSuperior.getCeldasSuperiores()){
            configurarValoresCelda(celda);
        }

    }

    private void configurarValoresCelda(CeldaSuperior celda) {
        String numeroCelda = celda.getNumeroCelda().toUpperCase();
        if(numeroCelda.startsWith("O")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.COMUN);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));
        } else if(numeroCelda.startsWith("S")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.SEMI_CAMA);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        } else if(numeroCelda.startsWith("C")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.CAMA);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        } else if(numeroCelda.startsWith("U")){
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setCalidad(TipoBus.SUIT);
            celda.setNumeroAsiento(numeroCelda.trim().substring(2));

        }else{
            celda.setTipoCelda(TipoCelda.OTRO);
        }
    }



}
