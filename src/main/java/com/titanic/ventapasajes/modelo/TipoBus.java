package com.titanic.ventapasajes.modelo;

public enum TipoBus {

	COMUN("O - Comun"), SEMI_CAMA ("S - SemiCama"), CAMA ("C - Cama"), SUIT ("V - Suit");


    private String descripcion;

    TipoBus(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion(){
        return descripcion;
    }
}
