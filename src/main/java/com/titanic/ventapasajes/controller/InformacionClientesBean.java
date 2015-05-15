package com.titanic.ventapasajes.controller;


import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.security.Seguridad;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroProgramacionService;
import com.titanic.ventapasajes.service.RegistroVentaService;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@Named
@ViewScoped
public class InformacionClientesBean implements Serializable {

    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroVentaService ventaService;

    @Inject
    private RegistroProgramacionService programacionService;

    @Inject
    private RegistroClienteService clienteService;

    @Inject
    private HttpServletRequest request;


    @Inject
    private Seguridad seguridad;


    private Programacion programacion;

    private Venta venta;

    private List<BoletoInferior> boletosReservadosInferiores = new ArrayList<>();
    private List<BoletoSuperior> boletosReservadosSuperiores = new ArrayList<>();

    private List<BoletoInferior> boletosPagadosInferiores = new ArrayList<>();
    private List<BoletoSuperior> boletosPagadosSuperiores = new ArrayList<>();

    @PostConstruct
    public void init() {

        String programacionId = (String) request.getSession().getAttribute("programacionId");

        programacion = programacionService.obtenerProgramacion(Long.valueOf(programacionId));

        venta = ventaService.obtenerVenta(programacion);

        obtenerBoletosInferioresReservadosYPagados();
        obtenerBoletosSuperioresReservadosYPagados();

    }

    private void obtenerBoletosSuperioresReservadosYPagados() {
        for (FilaBoletoSuperior filaBoletoSuperior : venta.getFilasBoletoSuperiores()) {

            for (BoletoSuperior boletoSuperior : filaBoletoSuperior.getBoletosSuperiores()) {

                if (boletoSuperior.getEstadoBoleto() == EstadoBoleto.RESERVADO) {

                    if (boletoSuperior.getUsuario().getIdeUsuario() == seguridad.getUsuarioLogeado().getUsuario().getIdeUsuario()) {
                        Cliente cliente = new Cliente();
                        cliente.setEdad(0);
                        cliente.setSexo(Sexo.FEMENINO);
                        cliente.setTipoDocumento(TipoDocumento.DNI);
                        cliente.setTipoPersona(TipoPersona.NATURAL);
                        cliente.setDebePresentarCartaNotarial(false);
                        boletoSuperior.setCliente(cliente);
                        boletosReservadosSuperiores.add(boletoSuperior);
                    }
                }

                if(boletoSuperior.getEstadoBoleto() == EstadoBoleto.PAGADO){
                    boletosPagadosSuperiores.add(boletoSuperior);
                }
            }
        }
    }

    private void obtenerBoletosInferioresReservadosYPagados() {
        for (FilaBoletoInferior filaBoletoInferior : venta.getFilasBoletosInferiores()) {

            for (BoletoInferior boletoInferior : filaBoletoInferior.getBoletosInferiores()) {

                if (boletoInferior.getEstadoBoleto() == EstadoBoleto.RESERVADO) {

                    if (boletoInferior.getUsuario().getIdeUsuario() == seguridad.getUsuarioLogeado().getUsuario().getIdeUsuario()) {
                        Cliente cliente = new Cliente();
                        cliente.setEdad(0);
                        cliente.setSexo(Sexo.FEMENINO);
                        cliente.setTipoDocumento(TipoDocumento.DNI);
                        cliente.setTipoPersona(TipoPersona.NATURAL);
                        cliente.setDebePresentarCartaNotarial(false);
                        boletoInferior.setCliente(cliente);
                        boletosReservadosInferiores.add(boletoInferior);
                    }
                }
                if(boletoInferior.getEstadoBoleto() == EstadoBoleto.PAGADO){
                    boletosPagadosInferiores.add(boletoInferior);
                }
            }
        }
    }


    public List<String> completeClientes(String query) {
        List<Cliente> todosLosClientes = clienteService.buscarTodos();
        List<String> dnisFiltrados = new ArrayList<>();

        for (Cliente cliente : todosLosClientes) {
            if (cliente.getNumeroDocumento().toLowerCase().startsWith(query)) {
                dnisFiltrados.add(cliente.getNumeroDocumento());
            }
        }
        return dnisFiltrados;
    }


    public void setearCliente(Cliente cliente) {
        if (cliente != null) {
            Cliente clienteBD = clienteService.obtenerClientePorNumeroDocumento(cliente.getNumeroDocumento());
            cliente.setNumeroDocumento(clienteBD.getNumeroDocumento());
            cliente.setEdad(clienteBD.getEdad());
            cliente.setSexo(clienteBD.getSexo());
            cliente.setNombreCliente(clienteBD.getNombreCliente());
            cliente.setIdeCliente(clienteBD.getIdeCliente());
            cliente.setNumeroTelefono(clienteBD.getNumeroTelefono());
        }


    }

    @Transaccion
    public void registrarVentaConCliente() {

        try{
            if (boletosReservadosSuperiores.size()>0 || boletosReservadosInferiores.size() > 0) {

                for (int i = 0; i < boletosReservadosSuperiores.size(); i++) {

                    Cliente cliente = boletosReservadosSuperiores.get(i).getCliente();
                    cliente = clienteService.adicionarCliente(cliente);
                    boletosReservadosSuperiores.get(i).setCliente(cliente);
                    boletosReservadosSuperiores.get(i).setEstadoBoleto(EstadoBoleto.PAGADO);
                    Calendar fechaVenta = Calendar.getInstance();
                    boletosReservadosSuperiores.get(i).setFechaVenta(fechaVenta.getTime());
                    boletosReservadosSuperiores.get(i).setHoraSalida(programacion.getHoraSalida());


                }

                for (int i = 0; i < boletosReservadosInferiores.size(); i++) {

                    Cliente cliente = boletosReservadosInferiores.get(i).getCliente();
                    cliente = clienteService.adicionarCliente(cliente);
                    boletosReservadosInferiores.get(i).setCliente(cliente);
                    boletosReservadosInferiores.get(i).setEstadoBoleto(EstadoBoleto.PAGADO);
                    Calendar fechaVenta = Calendar.getInstance();
                    boletosReservadosInferiores.get(i).setFechaVenta(fechaVenta.getTime());
                    boletosReservadosInferiores.get(i).setHoraSalida(programacion.getHoraSalida());


                }


                this.venta = ventaService.registrarVenta(venta);

                this.boletosReservadosInferiores = new ArrayList<>();
                this.boletosReservadosSuperiores = new ArrayList<>();
                this.boletosPagadosInferiores = new ArrayList<>();
                this.boletosPagadosSuperiores = new ArrayList<>();

                obtenerBoletosInferioresReservadosYPagados();
                obtenerBoletosSuperioresReservadosYPagados();

                //printSilentPDF();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta Satisfactoria", "Venta Satisfactoria");

                FacesContext.getCurrentInstance().addMessage(null, message);



            }


        }catch(Exception ex){
            ex.printStackTrace();

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Venta de Boletos", "No se pudo vender los Boletos. Contactar a Sistemas.");

            FacesContext.getCurrentInstance().addMessage(null, message);
        }

    }


    public Sexo[] getSexo() {
        return Sexo.values();
    }


    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Programacion getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Programacion programacion) {
        this.programacion = programacion;
    }

    public List<BoletoInferior> getBoletosReservadosInferiores() {
        return boletosReservadosInferiores;
    }

    public void setBoletosReservadosInferiores(List<BoletoInferior> boletosReservadosInferiores) {
        this.boletosReservadosInferiores = boletosReservadosInferiores;
    }

    public List<BoletoSuperior> getBoletosReservadosSuperiores() {
        return boletosReservadosSuperiores;
    }

    public void setBoletosReservadosSuperiores(List<BoletoSuperior> boletosReservadosSuperiores) {
        this.boletosReservadosSuperiores = boletosReservadosSuperiores;
    }

    public List<BoletoInferior> getBoletosPagadosInferiores() {
        return boletosPagadosInferiores;
    }

    public void setBoletosPagadosInferiores(List<BoletoInferior> boletosPagadosInferiores) {
        this.boletosPagadosInferiores = boletosPagadosInferiores;
    }

    public List<BoletoSuperior> getBoletosPagadosSuperiores() {
        return boletosPagadosSuperiores;
    }

    public void setBoletosPagadosSuperiores(List<BoletoSuperior> boletosPagadosSuperiores) {
        this.boletosPagadosSuperiores = boletosPagadosSuperiores;
    }
}
