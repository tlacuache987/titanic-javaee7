package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 7/28/14.
 */
public enum EstadoBoleto {

    LIBRE("LIBRE"), RESERVADO("RESERVADO"), PAGADO("PAGADO"), NO_DISPONIBLE("NO DISPONIBLE");



    private String descripcion;

    EstadoBoleto(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}