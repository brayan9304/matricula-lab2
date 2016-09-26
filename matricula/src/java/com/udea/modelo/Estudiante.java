/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.modelo;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Brayan Barrientos
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByIdestudiante", query = "SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante"),
    @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estudiante.findByPrograma", query = "SELECT e FROM Estudiante e WHERE e.programa = :programa")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idestudiante")
    private Integer idestudiante;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "programa")
    private String programa;
    @Column
    private byte[] foto;

    
    
    @JoinTable(name = "estudiante_materia", joinColumns = {
        @JoinColumn(name = "estudiante_idestudiante", referencedColumnName = "idestudiante")}, inverseJoinColumns = {
        @JoinColumn(name = "materia_idmateria", referencedColumnName = "idmateria")})
    @ManyToMany
    private List<Materia> materiaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Constancia> constanciaCollection;

    public Estudiante() {
    }

    public Estudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Estudiante(Integer idestudiante, String nombre, String programa,byte[] foto) {
        this.idestudiante = idestudiante;
        this.nombre = nombre;
        this.programa = programa;
        this.foto = foto;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @XmlTransient
    public List<Materia> getMateriaCollection() {
        return materiaCollection;
    }

    public void setMateriaCollection(List<Materia> materiaCollection) {
        this.materiaCollection = materiaCollection;
    }

    @XmlTransient
    public List<Constancia> getConstanciaCollection() {
        return constanciaCollection;
    }

    public void setConstanciaCollection(List<Constancia> constanciaCollection) {
        this.constanciaCollection = constanciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.modelo.Estudiante[ idestudiante=" + idestudiante + " ]";
    }
    
     public String getFotoBase64() throws IOException {
        String mimeType;
        try (InputStream is = new BufferedInputStream(new ByteArrayInputStream(foto))) {
            mimeType = URLConnection.guessContentTypeFromStream(is);
        }
        String base64 = DatatypeConverter.printBase64Binary(foto);
        System.out.println("data:" + mimeType + ";base64," + base64);
        return "data:" + mimeType + ";base64," + base64;
    }
    
}
