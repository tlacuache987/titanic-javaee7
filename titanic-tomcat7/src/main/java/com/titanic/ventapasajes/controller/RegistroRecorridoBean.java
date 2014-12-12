package com.titanic.ventapasajes.controller;

import com.titanic.ventapasajes.modelo.*;
import com.titanic.ventapasajes.repositorio.TerminalRepositorio;
import com.titanic.ventapasajes.service.RegistroClienteService;
import com.titanic.ventapasajes.service.RegistroRecorridoService;
import com.titanic.ventapasajes.util.FacesUtil;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josediaz on 7/25/14.
 */

@Named
@ViewScoped
public class RegistroRecorridoBean implements Serializable {



    private static final long serialVersionUID = 1L;


    @Inject
    private RegistroRecorridoService recorridoService;


    @Inject
    private TerminalRepositorio terminalRepositorio;

    private TarifaGeneral precioSeleccionado;
    private List<Terminal> terminales;


    public RegistroRecorridoBean() {
        recorrido = new Recorrido();
        recorrido.setRuta("ORIGEN-DESTINO");


    }


    private Recorrido recorrido;


    public void inicializar(){
        if(!FacesUtil.isPostback()){
            //inicializar listas
            terminales  = terminalRepositorio.listarTerminales();

            if(recorrido.getPrecios() == null || recorrido.getPrecios().isEmpty()){

                List<TarifaGeneral> precios = new ArrayList<>();

                for(TipoBus tipoBus: TipoBus.values()){
                    TarifaGeneral precio = new TarifaGeneral();
                    precio.setPrecio(new BigDecimal("0.00"));
                    precio.setTipoBus(tipoBus);
                    precio.setTipoPasaje("INGRESE CONCEPTO");
                    precio.setRecorrido(this.recorrido);
                    precios.add(precio);
                }

                recorrido.setPrecios(precios);
            }

        }
    }

    public List<Terminal> getTerminales() {
        return terminales;
    }

    public void setTerminales(List<Terminal> terminales) {
        this.terminales = terminales;
    }

    public void registrarRecorrido() {
        this.recorrido = recorridoService.registrarRecorrido(this.recorrido);
        limpiarFormulario();
        FacesUtil.adicionarMensajeInfo("El Recorrido se registro correctamente");
    }

    private void limpiarFormulario() {
        recorrido = new Recorrido();
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }


    public TipoBus[] getTiposBus() {
        return TipoBus.values();
    }


    public boolean isEditando(){
        return this.recorrido.getIdeRecorrido() !=null;
    }



    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {





            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Destino modificado", "Anterior: " + oldValue + ", Nuevo:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }






}
