/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.negocio;

import com.udea.modelo.Constancia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Brayan Barrientos
 */
@Local
public interface ConstanciaFacadeLocal {

    void create(Constancia constancia);

    void edit(Constancia constancia);

    void remove(Constancia constancia);

    Constancia find(Object id);

    List<Constancia> findAll();

    List<Constancia> findRange(int[] range);

    int count();
    
}
