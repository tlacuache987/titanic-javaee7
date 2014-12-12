package com.titanic.ventapasajes.repositorio;

import com.titanic.ventapasajes.modelo.TarifaGeneral;
import com.titanic.ventapasajes.modelo.Terminal;
import com.titanic.ventapasajes.repositorio.filtros.TerminalFiltros;
import com.titanic.ventapasajes.service.NegocioExcepciones;
import com.titanic.ventapasajes.util.jpa.Transaccion;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by josediaz on 7/25/14.
 */
public class TarifaGeneralRepositorio implements Serializable {



    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager entityManager;

    public TarifaGeneral buscarTarifaGeneralporId(Long ideTarifaGeneral) {
        return this.entityManager.find(TarifaGeneral.class, ideTarifaGeneral);
    }


    public TarifaGeneral adicionarTarifaGeneral(TarifaGeneral tarifaGeneral) {
        return entityManager.merge(tarifaGeneral);
    }



}


