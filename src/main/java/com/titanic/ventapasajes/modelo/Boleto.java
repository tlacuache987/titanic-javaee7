package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by josediaz on 7/28/14.
 */
@Entity
@Table(name = "pvm_boleto")
public class Boleto implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3506276599531512837L;
	private Long ideBoleto;
    private String asiento;
    private BigDecimal precio;
    private Cliente cliente;
    private EstadoBoleto estadoBoleto;
    private Venta venta;
    private Usuario usuario;
    private Boolean presentoCartaNotarial;

    //campos para facilidad en la generacion del reporte
    private String numeroDocumento;
    private String nombresCliente;
    private String fechaVenta;
    private String horaSalida;
    private String origen;
    private String destino;


    @Id
    @GeneratedValue
    @Column(name="ide_boleto", nullable = false, length= 10)
    public Long getIdeBoleto() {
        return ideBoleto;
    }

    public void setIdeBoleto(Long ideBoleto) {
        this.ideBoleto = ideBoleto;
    }

    @Size(max = 10)
    @Column(name="asiento", nullable=false, length=10)
    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }


    @NotNull
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @ManyToOne
    @JoinColumn(name = "ide_cliente", nullable = true)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado",nullable = false, length = 20)
    public EstadoBoleto getEstadoBoleto() {
        return estadoBoleto;
    }

    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }

    @ManyToOne
    @JoinColumn(name = "ide_venta", nullable = false)
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @ManyToOne
    @JoinColumn(name = "vendedor", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    //Datos de la Venta para facilidad en el reporte

    @Column(name="numero_documento", nullable=true, length=10)
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Column(name="nombre_cliente", nullable=true, length = 255)
    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    @Column(name="fecha_venta", nullable=true, length = 12)
    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Column(name="hora_salida", nullable=true, length = 10)
    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Column(name="origen", nullable=true, length = 50)
    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Column(name="destino", nullable=true, length = 50)
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }


    @Column(name="presento_carta_notarial", nullable = true)
    public Boolean getPresentoCartaNotarial() {
        return presentoCartaNotarial;
    }

    public void setPresentoCartaNotarial(Boolean presentoCartaNotarial) {
        this.presentoCartaNotarial = presentoCartaNotarial;
    }

    @Override
    public String toString() {
        return "Boleto{" +
                "ideBoleto=" + ideBoleto +
                ", asiento='" + asiento + '\'' +
                ", cliente=" + cliente +
                ", estadoBoleto=" + estadoBoleto +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boleto boleto = (Boleto) o;

        if (!asiento.equals(boleto.asiento)) return false;
        if (ideBoleto != null ? !ideBoleto.equals(boleto.ideBoleto) : boleto.ideBoleto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ideBoleto != null ? ideBoleto.hashCode() : 0;
        result = 31 * result + asiento.hashCode();
        return result;
    }
}
