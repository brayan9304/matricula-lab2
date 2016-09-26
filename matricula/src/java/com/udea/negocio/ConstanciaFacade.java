/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.negocio;

import com.udea.modelo.Constancia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brayan Barrientos
 */
@Stateless
public class ConstanciaFacade extends AbstractFacade<Constancia> implements ConstanciaFacadeLocal {

    @PersistenceContext(unitName = "matriculaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConstanciaFacade() {
        super(Constancia.class);
    }
    
}
