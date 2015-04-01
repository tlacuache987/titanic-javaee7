package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by josediaz on 7/19/14.
 */

@Entity
@Table(name = "pvm_celda_superior")
public class CeldaSuperior implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideCelda;
    private String numeroCelda;
    private TipoCelda tipoCelda;
    private EstadoBoleto estadoCelda;
    private FilaSuperior fila;
    private String numeroAsiento;
    private TipoBus calidad;
    private TarifaGeneral tarifaGeneral;


    @Id
    @GeneratedValue
    @Column(name="ide_celda", nullable = false, length= 10)
    public Long getIdeCelda() {
        return ideCelda;
    }

    public void setIdeCelda(Long ideCelda) {
        this.ideCelda = ideCelda;
    }


    @Size(max = 10)
    @Column(name="numero_celda", nullable=false, length=10)
    public String getNumeroCelda() {
        return numeroCelda;
    }

    public void setNumeroCelda(String numeroCelda) {
        this.numeroCelda = numeroCelda;
    }


    @Column(name="numero_asiento", nullable=true, length=10)
    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }



    @Enumerated(EnumType.STRING)
    @Column(name="calidad", nullable=true, length = 50)
    public TipoBus getCalidad() {
        return calidad;
    }

    public void setCalidad(TipoBus calidad) {
        this.calidad = calidad;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_celda", nullable=false, length = 50)
    public TipoCelda getTipoCelda() {
        return tipoCelda;
    }

    public void setTipoCelda(TipoCelda tipoCelda) {
        this.tipoCelda = tipoCelda;
    }


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_celda", nullable=false, length = 50)
    public EstadoBoleto getEstadoCelda() {
        return estadoCelda;
    }


    public void setEstadoCelda(EstadoBoleto estadoCelda) {
        this.estadoCelda = estadoCelda;
    }


    @ManyToOne
    @JoinColumn(name = "ide_fila", nullable = false)
    public FilaSuperior getFila() {
        return fila;
    }

    public void setFila(FilaSuperior fila) {
        this.fila = fila;
    }

}
