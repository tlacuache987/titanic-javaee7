package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.util.FacesUtil;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@ViewScoped
public class SeleccionarAsientosBean implements Serializable {


    private static final long serialVersionUID = 1L;

    private Programacion programacion;





    public void inicializar() {
        if (!FacesUtil.isPostback()) {

        }
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

    public TipoProgramacion[] getTipoProgramacion() {
        return TipoProgramacion.values();
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public EstadoCelda[] getEstadoCelda() {
        return EstadoCelda.values();
    }
}
