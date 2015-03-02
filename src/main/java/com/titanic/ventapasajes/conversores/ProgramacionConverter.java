package com.titanic.ventapasajes.conversores;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.ProgramacionRepositorio;
import com.titanic.ventapasajes.util.cdi.CDIServiceLocator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
@FacesConverter(forClass=Programacion.class)
public class ProgramacionConverter implements Converter {

    private ProgramacionRepositorio programacionRepositorio;

    public ProgramacionConverter() {
        this.programacionRepositorio = (ProgramacionRepositorio) CDIServiceLocator.getBean(ProgramacionRepositorio.class);
    }

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Programacion retorno = null;

        if (value != null) {
            retorno = this.programacionRepositorio.obtenerProgramacion(new Long(value));
        }

        return retorno;
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value!=null){
            Programacion programacion = (Programacion) value;
            return programacion.getIdeProgramacion() == null ? null :  programacion.getIdeProgramacion().toString();
        }

        return "";
    }
}
