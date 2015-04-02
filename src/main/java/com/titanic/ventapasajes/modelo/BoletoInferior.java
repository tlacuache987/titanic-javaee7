package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Celeritech Peru on 01/04/2015.
 */
@Entity
@Table(name = "pvm_boleto_inferior")
public class BoletoInferior implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideBoleto;
    private String numeroBoleto;
    private TipoCelda tipoBoleto;
    private EstadoBoleto estadoBoleto;
    private FilaBoletoInferior filaBoletoInferior;
    private String numeroAsiento;
    private TipoBus calidad;

    private BigDecimal precio;
    private Cliente cliente;
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
    @Column(name="numero_boleto", nullable=false, length=10)
    public String getNumeroBoleto() {
        return numeroBoleto;
    }

    public void setNumeroBoleto(String numeroBoleto) {
        this.numeroBoleto = numeroBoleto;
    }




    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="tipo_boleto", nullable=false, length = 50)
    public TipoCelda getTipoBoleto() {
        return tipoBoleto;
    }

    public void setTipoBoleto(TipoCelda tipoBoleto) {
        this.tipoBoleto = tipoBoleto;
    }


    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="estado_boleto", nullable=false, length = 50)
    public EstadoBoleto getEstadoBoleto() {
        return estadoBoleto;
    }


    public void setEstadoBoleto(EstadoBoleto estadoBoleto) {
        this.estadoBoleto = estadoBoleto;
    }


    @ManyToOne
    @JoinColumn(name = "ide_fila", nullable = false)
    public FilaBoletoInferior getFilaBoletoInferior() {
        return filaBoletoInferior;
    }

    public void setFilaBoletoInferior(FilaBoletoInferior filaBoletoInferior) {
        this.filaBoletoInferior = filaBoletoInferior;
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



    @Column(name="presento_carta_notarial", nullable = true)
    public Boolean getPresentoCartaNotarial() {
        return presentoCartaNotarial;
    }

    public void setPresentoCartaNotarial(Boolean presentoCartaNotarial) {
        this.presentoCartaNotarial = presentoCartaNotarial;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoletoInferior that = (BoletoInferior) o;

        return ideBoleto.equals(that.ideBoleto);

    }

    @Override
    public int hashCode() {
        return ideBoleto.hashCode();
    }

    @Override
    public String toString() {
        return "BoletoSuperior{" +
                "ideBoleto=" + ideBoleto +
                ", numeroBoleto='" + numeroBoleto + '\'' +
                ", tipoBoleto=" + tipoBoleto +
                ", estadoBoleto=" + estadoBoleto +
                ", filaBoletoInferior =" + filaBoletoInferior +
                ", numeroAsiento='" + numeroAsiento + '\'' +
                ", calidad=" + calidad +
                ", precio=" + precio +
                ", cliente=" + cliente +
                ", venta=" + venta +
                ", usuario=" + usuario +
                ", presentoCartaNotarial=" + presentoCartaNotarial +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombresCliente='" + nombresCliente + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
