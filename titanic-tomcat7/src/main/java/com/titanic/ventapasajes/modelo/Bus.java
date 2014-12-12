package com.titanic.ventapasajes.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;



@Entity
@Table(name = "pvm_bus")
public class Bus implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long ideBus;
	private String descripcionBus;
	private TipoPlanta tipoPlanta;
	private TipoBus tipoBus;
	private String placa;
	private String numeroMotor;
	private Boolean conAireAcondicionado;
	private List<Fila> filasInferiores;
    private List<FilaSuperior> filasSuperiores;
	
	@Id
	@GeneratedValue
	@Column(name="ide_bus", nullable = false, length= 10)
	public Long getIdeBus() {
		return ideBus;
	}
	public void setIdeBus(Long ideBus) {
		this.ideBus = ideBus;
	}
	@NotBlank
	@Column(name="descripcion_bus", nullable=false, length = 255)	
	public String getDescripcionBus() {
		return descripcionBus;
	}
	public void setDescripcionBus(String descripcionBus) {
		this.descripcionBus = descripcionBus;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_planta", nullable=false, length = 50)	
	public TipoPlanta getTipoPlanta() {
		return tipoPlanta;
	}
	public void setTipoPlanta(TipoPlanta tipoPlanta) {
		this.tipoPlanta = tipoPlanta;
	}
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_bus", nullable=false, length = 50)	
	public TipoBus getTipoBus() {
		return tipoBus;
	}
	public void setTipoBus(TipoBus tipoBus) {
		this.tipoBus = tipoBus;
	}
	
	@NotBlank
	@Column(name="placa", nullable=false, length = 10)		
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	

	@Column(name="numero_motor", nullable=true, length = 50)
	public String getNumeroMotor() {
		return numeroMotor;
	}
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	@Column(name="con_aire_acondicionado")
	public Boolean getConAireAcondicionado() {
		return conAireAcondicionado;
	}
	public void setConAireAcondicionado(Boolean conAireAcondicionado) {
		this.conAireAcondicionado = conAireAcondicionado;
	}
	@Override
	public String toString() {
		return "Bus [ideBus=" + ideBus + ", descripcionBus=" + descripcionBus
				+ ", tipoPlanta=" + tipoPlanta + ", tipoBus=" + tipoBus
				+ ", placa=" + placa + ", numeroMotor=" + numeroMotor
				+ ", conAireAcondicionado=" + conAireAcondicionado + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ideBus == null) ? 0 : ideBus.hashCode());
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
		Bus other = (Bus) obj;
		if (ideBus == null) {
			if (other.ideBus != null)
				return false;
		} else if (!ideBus.equals(other.ideBus))
			return false;
		return true;
	}


    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<Fila> getFilasInferiores() {
        return filasInferiores;
    }

    public void setFilasInferiores(List<Fila> filasPrimeraPlanta) {
        this.filasInferiores = filasPrimeraPlanta;
    }

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<FilaSuperior> getFilasSuperiores() {
        return filasSuperiores;
    }

    public void setFilasSuperiores(List<FilaSuperior> filasSegundaPlanta) {
        this.filasSuperiores = filasSegundaPlanta;
    }
}
