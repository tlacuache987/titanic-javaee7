package com.titanic.ventapasajes.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.*;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

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


    public void inicializar() {
        if (!FacesUtil.isPostback()) {
            if(!isEditando()) {
                bus.setFilasInferiores(getFilasYCeldasInferiores(bus));
                bus.setFilasSuperiores(getFilasYCeldasSuperiores(bus));
            }
        }
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
                celda.setEstadoCelda(EstadoBoleto.LIBRE);
                celda.setTipoCelda(TipoCelda.OTRO);
                celda.setCalidad(TipoBus.COMUN);
                celda.setFila(fila);
                fila.getCeldasInferiores().add(celda);
            }
            planta.add(fila);
        }
        return planta;
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
                celda.setEstadoCelda(EstadoBoleto.LIBRE);
                celda.setTipoCelda(TipoCelda.OTRO);
                celda.setCalidad(TipoBus.COMUN);
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
        String numeroCeldaStr = celda.getNumeroCelda().toUpperCase();

        try{
            Integer.parseInt(numeroCeldaStr);
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setNumeroAsiento(numeroCeldaStr);
        }catch(NumberFormatException ex){
            celda.setTipoCelda(TipoCelda.OTRO);
            celda.setCalidad(TipoBus.COMUN);
            ex.printStackTrace();
        }
    }

    private void updateTipoCeldaSuperior(FilaSuperior filaSuperior) {
        for(CeldaSuperior celda: filaSuperior.getCeldasSuperiores()){
            configurarValoresCelda(celda);
        }

    }

    private void configurarValoresCelda(CeldaSuperior celda) {
        String numeroCeldaStr = celda.getNumeroCelda().toUpperCase();
        try{
            Integer.parseInt(numeroCeldaStr);
            celda.setTipoCelda(TipoCelda.ASIENTO);
            celda.setNumeroAsiento(numeroCeldaStr);
        }catch(NumberFormatException ex){
            celda.setTipoCelda(TipoCelda.OTRO);
            celda.setCalidad(TipoBus.COMUN);
            ex.printStackTrace();
        }
    }


    public TipoBus[] getCalidad() {
        return TipoBus.values();
    }


}
