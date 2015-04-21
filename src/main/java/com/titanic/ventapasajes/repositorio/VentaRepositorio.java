package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Hibernate;

import com.titanic.ventapasajes.modelo.Bus;
import com.titanic.ventapasajes.modelo.Recorrido;
import com.titanic.ventapasajes.modelo.Venta;

/**
 * Created by josediaz on 7/28/14.
 */
public class VentaRepositorio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public Venta obtenerVenta(Long id){
        return entityManager.find(Venta.class, id);
    }


    public Venta adicionarVenta(Venta venta) {

        return entityManager.merge(venta);
    }


    public Venta obtenerVenta(Date fechaVenta, Recorrido ruta, String horaSalida, Bus bus) {

        try{

            Venta venta = entityManager.createQuery("from Venta where ideVenta = :ideVenta", Venta.class)
                    //"fechaVenta = :fechaVenta and " +
                    //"ruta.ideRecorrido = :ideRecorrido and " +
                    //"horaSalida = :horaSalida and " +
                    //"bus.ideBus = :ideBus", Venta.class)
                    //.setParameter("fechaVenta",  new Date() )//fechaVenta)
                    //.setParameter("ideRecorrido", 2l)//ruta.getIdeRecorrido())
                    //.setParameter("horaSalida", "00:00") //horaSalida)
                    //.setParameter("ideBus", 3l) //bus.getIdeBus())
                    .setParameter("ideVenta", 35l)
                    .getSingleResult();

            //Hibernate.initialize(venta.getBoletos());
            return venta;
        }catch(NoResultException e){
            return null;
        }


    }
}
