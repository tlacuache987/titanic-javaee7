package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Entity
@Table(name = "pvm_programacion")
public class Programacion implements Serializable{


    /**
     *
     */
    private static final long serialVersionUID = -2197964758413800707L;
    private Long ideProgramacion;
    private Date fechaProgramacion;
    private Bus bus;
    private String horaSalida;
    private String horaLlegada;
    private TipoProgramacion tipoProgramacion;


    @Id
    @GeneratedValue
    @Column(name="ide_programacion", nullable = false, length= 10)
    public Long getIdeProgramacion() {
        return ideProgramacion;
    }

    public void setIdeProgramacion(Long ideProgramacion) {
        this.ideProgramacion = ideProgramacion;
    }

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_programacion", nullable = false)
    public Date getFechaProgramacion() {
        return fechaProgramacion;
    }

    public void setFechaProgramacion(Date fechaProgramacion) {
        this.fechaProgramacion = fechaProgramacion;
    }

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ide_bus", nullable = false)
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @NotNull
    @Size(max = 10)
    @Column(name="hora_salida", nullable=false, length=10)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @NotNull
    @Size(max = 10)
    @Column(name="hora_llegada", nullable=false, length=10)
    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_programacion", nullable=false, length = 50)
    public TipoProgramacion getTipoProgramacion() {
        return tipoProgramacion;
    }

    public void setTipoProgramacion(TipoProgramacion tipoProgramacion) {
        this.tipoProgramacion = tipoProgramacion;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Programacion that = (Programacion) o;

        if (ideProgramacion != null ? !ideProgramacion.equals(that.ideProgramacion) : that.ideProgramacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ideProgramacion != null ? ideProgramacion.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Programacion{" +
                "ideProgramacion=" + ideProgramacion +
                ", fechaProgramacion=" + fechaProgramacion +
                ", bus=" + bus +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", tipoProgramacion=" + tipoProgramacion +
                '}';
    }
}
