/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brayan Barrientos
 */
@Entity
@Table(name = "constancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constancia.findAll", query = "SELECT c FROM Constancia c"),
    @NamedQuery(name = "Constancia.findByIdconstancia", query = "SELECT c FROM Constancia c WHERE c.constanciaPK.idconstancia = :idconstancia"),
    @NamedQuery(name = "Constancia.findBySemestre", query = "SELECT c FROM Constancia c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Constancia.findByIdestudiante", query = "SELECT c FROM Constancia c WHERE c.constanciaPK.idestudiante = :idestudiante"),
    @NamedQuery(name = "Constancia.findByFecha", query = "SELECT c FROM Constancia c WHERE c.fecha = :fecha")})
public class Constancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @GeneratedValue(strategy=GenerationType.AUTO)
    protected ConstanciaPK constanciaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idestudiante", referencedColumnName = "idestudiante", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estudiante estudiante;

    public Constancia() {
    }

    public Constancia(ConstanciaPK constanciaPK) {
        this.constanciaPK = constanciaPK;
    }

    public Constancia(ConstanciaPK constanciaPK, int semestre, Date fecha) {
        this.constanciaPK = constanciaPK;
        this.semestre = semestre;
        this.fecha = fecha;
    }

    public Constancia(int idconstancia, int idestudiante) {
        this.constanciaPK = new ConstanciaPK(idconstancia, idestudiante);
    }

    public ConstanciaPK getConstanciaPK() {
        return constanciaPK;
    }

    public void setConstanciaPK(ConstanciaPK constanciaPK) {
        this.constanciaPK = constanciaPK;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (constanciaPK != null ? constanciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constancia)) {
            return false;
        }
        Constancia other = (Constancia) object;
        if ((this.constanciaPK == null && other.constanciaPK != null) || (this.constanciaPK != null && !this.constanciaPK.equals(other.constanciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Constancia[ constanciaPK=" + constanciaPK + " ]";
    }
    
}
