package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by josediaz on 7/24/14.
 */
@Entity
@Table(name = "pvm_hora_salida")
public class HoraSalida {



    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private Long ideHoraSalida;
    private String horaSalida;
    private Recorrido recorrido;



    @Id
    @GeneratedValue
    @Column(name="ide_hora_salida", nullable = false, length= 10)
    public Long getIdeHoraSalida() {
        return ideHoraSalida;
    }

    public void setIdeHoraSalida(Long ideHoraSalida) {
        this.ideHoraSalida = ideHoraSalida;
    }

    @NotNull
    @Column(name = "hora_salida", nullable = false, precision = 10, scale = 2)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @ManyToOne
    @JoinColumn(name = "ide_recorrido", nullable = false)
    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }
}
