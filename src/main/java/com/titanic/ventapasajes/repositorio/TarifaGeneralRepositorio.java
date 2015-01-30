package com.titanic.ventapasajes.repositorio;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.titanic.ventapasajes.modelo.TarifaGeneral;

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


