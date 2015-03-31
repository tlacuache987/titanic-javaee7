package com.titanic.ventapasajes.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "pvm_fila_superior")
public class FilaSuperior implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long ideFila;
    private List<CeldaSuperior> celdasSuperiores;
    private UbicacionPlanta ubicacionPlanta;
    private Bus bus;




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
    public List<CeldaSuperior> getCeldasSuperiores() {
        return celdasSuperiores;
    }

    public void setCeldasSuperiores(List<CeldaSuperior> celdas) {
        this.celdasSuperiores = celdas;
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
    @JoinColumn(name = "ide_bus", nullable = false)
    public Bus getBus() {
        return bus;
    }



    public void setBus(Bus bus) {
        this.bus = bus;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilaSuperior that = (FilaSuperior) o;

        if (!ideFila.equals(that.ideFila)) return false;

        return true;
    }
}
