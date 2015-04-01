package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.titanic.ventapasajes.modelo.Boleto;
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

    public Boleto adicionarBoleto(Boleto boleto){
        return entityManager.merge(boleto);
    }

    public Boleto buscarBoleto(String numeroAsiento, Long ideVenta){

        try {

            Boleto boletoRpta = entityManager.createQuery("from Boleto where " +
                    "asiento = :numeroAsiento and " +
                    "venta.ideVenta = :ideVenta", Boleto.class)
                    .setParameter("numeroAsiento", numeroAsiento)
                    .setParameter("ideVenta", ideVenta)
                    .getSingleResult();




            return boletoRpta;
        }catch(NoResultException e){
            return null;
        }
    }

    public Venta obtenerVenta(Date fechaVenta, Recorrido ruta, String horaSalida, Bus bus) {

        try{

            Venta venta = entityManager.createQuery("from Venta where " +
                    "fechaVenta = :fechaVenta and " +
                    "ruta.ideRecorrido = :ideRecorrido and " +
                    "horaSalida = :horaSalida and " +
                    "bus.ideBus = :ideBus", Venta.class)
                    .setParameter("fechaVenta", fechaVenta)
                    .setParameter("ideRecorrido", ruta.getIdeRecorrido())
                    .setParameter("horaSalida", horaSalida)
                    .setParameter("ideBus", bus.getIdeBus())
                    .getSingleResult();

            Hibernate.initialize(venta.getBoletos());
            return venta;
        }catch(NoResultException e){
            return null;
        }


    }
}
