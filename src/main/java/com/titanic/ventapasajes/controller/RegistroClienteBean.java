package com.titanic.ventapasajes.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.titanic.ventapasajes.modelo.Cliente;
import com.titanic.ventapasajes.modelo.Sexo;
import com.titanic.ventapasajes.modelo.TipoDocumento;
import com.titanic.ventapasajes.modelo.TipoPersona;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.util.FacesUtil;


@Named
@ViewScoped
public class RegistroClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RegistroClienteService clienteService;
	
	private Cliente cliente;
	
	public RegistroClienteBean(){
		cliente = new Cliente();
	}
	
	public void inicializar(){
		if(!FacesUtil.isPostback()){
			//inicializar listas
		}
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public TipoPersona[] getTiposPersona() {
		return TipoPersona.values();
	}

    public TipoDocumento[] getTiposDocumento() {
        return TipoDocumento.values();
    }


    public Sexo[] getSexo() {
        return Sexo.values();
    }
	
	public void registrarCliente(){
		this.cliente = clienteService.registrarCliente(this.cliente);
		limpiarFormulario();
		FacesUtil.adicionarMensajeInfo("El cliente se registro correctamente");
	}

	private void limpiarFormulario(){
		cliente = new Cliente();
		 
	}	
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		 
		
	}
	
	public boolean isEditando(){
		return this.cliente.getIdeCliente() !=null;
	}
		
	
}
