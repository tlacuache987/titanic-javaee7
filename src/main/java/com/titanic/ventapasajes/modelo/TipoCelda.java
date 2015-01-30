package com.titanic.ventapasajes.modelo;

/**
 * Created by josediaz on 7/19/14.
 */
public enum TipoCelda {

    ASIENTO("ASIENTO"),
    OTRO ("OTRO");



    private String descripcion;

    TipoCelda(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }

}
