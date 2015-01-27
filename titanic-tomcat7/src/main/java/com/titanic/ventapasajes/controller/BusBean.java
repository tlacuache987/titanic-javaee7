package com.titanic.ventapasajes.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.repositorio.BusRepositorio;
import com.titanic.ventapasajes.repositorio.filtros.BusFiltros;
import com.titanic.ventapasajes.util.FacesUtil;

/**
 * Created by josediaz on 7/20/14.
 */
@Named
@ViewScoped
public class BusBean implements Serializable {


    private static final long serialVersionUID = 1L;

    @Inject
    private BusRepositorio busRepositorio;

    private List<Bus> busesFiltrados;
    private BusFiltros filtros;

    private Bus busSeleccionado;


    @PostConstruct
    public void init(){
        filtros = new BusFiltros();
        buscarBusFiltros();
    }


    public BusBean(){
        filtros = new BusFiltros();
    }

    public void buscarBusFiltros(){
        busesFiltrados = busRepositorio.listarBusesFiltrados(filtros);

    }

    public void eliminarBus(){
        busRepositorio.removerBus(busSeleccionado);
        busesFiltrados.remove(busSeleccionado);
        FacesUtil.adicionarMensajeInfo("Bus " + busSeleccionado.getDescripcionBus() + " eliminado.");
    }


    public void selectBusFromDialog(Bus bus) {
        RequestContext.getCurrentInstance().closeDialog(bus);
    }

    public Bus getBusSeleccionado() {
        return busSeleccionado;
    }

    public void setBusSeleccionado(Bus busSeleccionado) {
        this.busSeleccionado = busSeleccionado;
    }

    public BusFiltros getFiltros() {
        return filtros;
    }

    public List<Bus> getBusesFiltrados() {
        return busesFiltrados;
    }
}

