package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.Programacion;
import com.titanic.ventapasajes.modelo.Usuario;
import com.titanic.ventapasajes.repositorio.filtros.ProgramacionFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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


        Session session = entityManager.unwrap(Session.class);
        Criteria criteria =  session.createCriteria(Programacion.class);
        if(programacionFiltros.getFechaProgramacion()!=null){
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(programacionFiltros.getFechaProgramacion());
            criteria.add(Restrictions.eq("fechaProgramacion", calendar.getTime()));
        }



        return criteria.addOrder(Order.asc("fechaProgramacion")).list();



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
