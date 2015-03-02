package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Celeritech Peru on 02/03/2015.
 */
public class ProgramacionRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Programacion> listarProgramacionesFiltradas(ProgramacionFiltros programacionFiltros) {


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Programacion.class);
        if(programacionFiltros.getFechaProgramacion()!=null){
            criteria.add(Restrictions.eq("fechaProgramacion", programacionFiltros.getFechaProgramacion()));
        }



        return criteria.addOrder(Order.desc("fechaProgramacion")).list();

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
