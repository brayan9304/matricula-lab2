/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Brayan Barrientos
 */
@Embeddable
public class ConstanciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    
    @Column(name = "idconstancia")
    private int idconstancia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestudiante")
    private int idestudiante;

    public ConstanciaPK() {
    }

    public ConstanciaPK(int idconstancia, int idestudiante) {
        this.idconstancia = idconstancia;
        this.idestudiante = idestudiante;
    }

    public int getIdconstancia() {
        return idconstancia;
    }

    public void setIdconstancia(int idconstancia) {
        this.idconstancia = idconstancia;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idconstancia;
        hash += (int) idestudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConstanciaPK)) {
            return false;
        }
        ConstanciaPK other = (ConstanciaPK) object;
        if (this.idconstancia != other.idconstancia) {
            return false;
        }
        if (this.idestudiante != other.idestudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.ConstanciaPK[ idconstancia=" + idconstancia + ", idestudiante=" + idestudiante + " ]";
    }
    
}
