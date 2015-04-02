package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by josediaz on 7/28/14.
 */
@Entity
@Table(name = "pvm_venta")
public class Venta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2197964758413800707L;
	private Long ideVenta;
    private Date fechaVenta;
    private Recorrido ruta;
    private String horaSalida;
    private Bus bus;
    private BigDecimal totalVenta;

    private List<FilaBoletoSuperior> filasBoletoSuperiores;
    private List<FilaBoletoInferior> filasBoletosInferiores;


    @Id
    @GeneratedValue
    @Column(name="ide_venta", nullable = false, length= 10)
    public Long getIdeVenta() {
        return ideVenta;
    }

    public void setIdeVenta(Long ideVenta) {
        this.ideVenta = ideVenta;
    }


    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_venta", nullable = false)
    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @ManyToOne
    @JoinColumn(name = "ide_recorrido", nullable = false)
    public Recorrido getRuta() {
        return ruta;
    }

    public void setRuta(Recorrido ruta) {
        this.ruta = ruta;
    }

    @Size(max = 10)
    @Column(name="hora_salida", nullable=false, length=10)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @ManyToOne
    @JoinColumn(name = "ide_bus", nullable = false)
    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @NotNull
    @Column(name = "total_venta", nullable = false, precision = 10, scale = 2)
    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }




    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<FilaBoletoInferior> getFilasBoletosInferiores() {
        return filasBoletosInferiores;
    }

    public void setFilasBoletosInferiores(List<FilaBoletoInferior> filasBoletosInferiores) {
        this.filasBoletosInferiores = filasBoletosInferiores;
    }

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<FilaBoletoSuperior> getFilasBoletoSuperiores() {
        return filasBoletoSuperiores;
    }

    public void setFilasBoletoSuperiores(List<FilaBoletoSuperior> filasBoletoSuperiores) {
        this.filasBoletoSuperiores = filasBoletoSuperiores;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "ideVenta=" + ideVenta +
                ", fechaVenta=" + fechaVenta +
                ", ruta=" + ruta +
                ", horaSalida='" + horaSalida + '\'' +
                ", bus=" + bus +
                ", totalVenta=" + totalVenta +
                ", filasBoletoSuperiores=" + filasBoletoSuperiores +
                ", filasBoletosInferiores=" + filasBoletosInferiores +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venta venta = (Venta) o;

        if (ideVenta != null ? !ideVenta.equals(venta.ideVenta) : venta.ideVenta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ideVenta != null ? ideVenta.hashCode() : 0;
    }
}
