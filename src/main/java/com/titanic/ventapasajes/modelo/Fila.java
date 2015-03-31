package com.titanic.ventapasajes.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "pvm_fila_inferior")
public class Fila implements Serializable{

	/**
	 * 
	 */
    private static final long serialVersionUID = 1L;
	
	private Long ideFila;
	private List<Celda> celdasInferiores;
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
    public List<Celda> getCeldasInferiores() {
        return celdasInferiores;
    }

    public void setCeldasInferiores(List<Celda> celdas) {
        this.celdasInferiores = celdas;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fila other = (Fila) obj;
		if (ideFila == null) {
			if (other.ideFila != null)
				return false;
		} else if (!ideFila.equals(other.ideFila))
			return false;
		return true;
	}
	
	
	

}
