package com.titanic.ventapasajes.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Celeritech Peru on 01/04/2015.
 */
@Entity
@Table(name = "pvm_fila_boleto_inferior")
public class FilaBoletoInferior implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideFila;
    private List<BoletoInferior> boletosInferiores;
    private UbicacionPlanta ubicacionPlanta;
    private Venta venta;


    @Id
    @GeneratedValue
    @Column(name="ide_fila", nullable = false, length= 10)
    public Long getIdeFila() {
        return ideFila;
    }

    public void setIdeFila(Long ideAsiento) {
        this.ideFila = ideAsiento;
    }


    @OneToMany(mappedBy = "fila", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public List<BoletoInferior> getBoletosInferiores() {
        return boletosInferiores;
    }

    public void setBoletosInferiores(List<BoletoInferior> boletosInferiores) {

        this.boletosInferiores = boletosInferiores;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="ubicacion_planta", nullable=false, length = 50)
    public UbicacionPlanta getUbicacionPlanta() {
        return ubicacionPlanta;
    }

    public void setUbicacionPlanta(UbicacionPlanta ubicacionPlanta) {
        this.ubicacionPlanta = ubicacionPlanta;
    }

    @ManyToOne
    @JoinColumn(name = "ide_venta", nullable = false)
    public Venta getVenta() {
        return venta;
    }



    public void setVenta(Venta venta) {
        this.venta = venta;
    }






    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((ideFila == null) ? 0 : ideFila.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FilaBoletoInferior other = (FilaBoletoInferior) obj;
        if (ideFila == null) {
            if (other.ideFila != null)
                return false;
        } else if (!ideFila.equals(other.ideFila))
            return false;
        return true;
    }



}
