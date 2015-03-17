package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
public class ProgramacionRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;


    public List<Programacion> buscarTodos(){
        return this.entityManager.createQuery("from Programacion").getResultList();
    }


    @SuppressWarnings("unchecked")
    public List<Programacion> listarProgramacionesFiltradas(ProgramacionFiltros programacionFiltros) {


        TypedQuery<Programacion> q = entityManager.createQuery("select p from Programacion p " +
                "where p.fechaProgramacion = :fechaProgramacion", Programacion.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(programacionFiltros.getFechaProgramacion());

        q.setParameter("fechaProgramacion", calendar.getTime(), TemporalType.DATE);



        return q.getResultList();

    }


    @Transaccion
    public void removerProgramacion(Programacion programacion) {

        try{
            programacion = obtenerProgramacion(programacion.getIdeProgramacion());
            entityManager.remove(programacion);
            entityManager.flush();
        }catch(PersistenceException e){
            throw new NegocioExcepciones("La programación no puede ser eliminada.");
        }

    }

    public Programacion obtenerProgramacion(Long id){
        return entityManager.find(Programacion.class, id);
    }

    public Programacion adicionarProgramacion(Programacion programacion) {
        return entityManager.merge(programacion);
    }
}
