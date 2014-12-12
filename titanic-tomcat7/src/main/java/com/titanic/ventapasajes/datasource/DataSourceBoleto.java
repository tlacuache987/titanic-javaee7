/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanic.ventapasajes.datasource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.titanic.ventapasajes.modelo.Boleto;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Jhon
 */
public class DataSourceBoleto implements JRDataSource{
    private List<Boleto> listaDR= new ArrayList<Boleto>();
    private int indice = -1;
    
    public boolean next() throws JRException {
    	System.out.println("==>Lista: "+listaDR.size());
       return ++indice < listaDR.size();
    }
    

    public Object getFieldValue(JRField jrf) throws JRException {
    	
        Object valor = null;  

            if("Anio".equals(jrf.getName())) {
            	if(listaDR.get(indice).getFechaVenta()!=null)
            		valor = listaDR.get(indice).getFechaVenta().subSequence(6, 4);
            	else
            		valor = "0000";
            }else if ("FechaEmision".equals(jrf.getName())){
                valor = listaDR.get(indice).getFechaVenta();
            }else if ("Mes".equals(jrf.getName())){
            	if(listaDR.get(indice).getFechaVenta()!=null)
            		valor = listaDR.get(indice).getFechaVenta().subSequence(3, 2);
            	else
            		valor = "00";
            }else if ("Dia".equals(jrf.getName())){
            	if(listaDR.get(indice).getFechaVenta()!=null)
            		valor = listaDR.get(indice).getFechaVenta().subSequence(0, 2);
            	else
            		valor = "00";
            }else if ("RUC".equals(jrf.getName())){
                valor =listaDR.get(indice).getCliente().getNumeroDocumento();
            }else if ("DNI".equals(jrf.getName())){
            	valor =listaDR.get(indice).getCliente().getNumeroDocumento();
            }else if("SerieNumero".equals(jrf.getName())) { 
                valor = listaDR.get(indice).getNumeroDocumento();
            }else if ("PrecioVenta".equals(jrf.getName())){
            	valor = listaDR.get(indice).getPrecio();
            }else if ("ValorVenta".equals(jrf.getName())){
                NumeroALetra num = new NumeroALetra();
                valor = num.Convertir(listaDR.get(indice).getPrecio().toString(), true,"SOLES"); 
            }else if ("Destino".equals(jrf.getName())){
                valor = listaDR.get(indice).getDestino();
            }else if ("Origen".equals(jrf.getName())){
                valor = listaDR.get(indice).getOrigen();
            }else if ("Pasajero".equals(jrf.getName())){
                valor = listaDR.get(indice).getNombresCliente();
            }else if ("Usuario".equals(jrf.getName())){
                valor = listaDR.get(indice).getUsuario().getNombreUsuario();
                
            }
            
            return valor; 
    }
    
    public void addDetalle(Boleto dr){
        this.listaDR.add(dr);
    }
}
