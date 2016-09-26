/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import com.udea.modelo.Constancia;
import com.udea.modelo.ConstanciaPK;
import com.udea.modelo.Estudiante;
import com.udea.modelo.Materia;
import java.io.Serializable;
import javax.ejb.EJB;
import com.udea.negocio.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Brayan
 */
public class MatriculaBean implements Serializable {

    private List<String> materias = new ArrayList<>();
    private String materia;
    private int creditos;
    private String nombreestudiante;
    private String programa;
    private UploadedFile foto;

    @EJB
    private ConstanciaFacadeLocal constanciaFacade;

    @EJB
    private MateriaFacadeLocal materiaFacede;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

    public EstudianteFacadeLocal getEstudianteFacade() {
        return estudianteFacade;
    }

    public void setEstudianteFacade(EstudianteFacadeLocal estudianteFacade) {
        this.estudianteFacade = estudianteFacade;
    }

    private int idconstancia;
    private int semestre;
    private int idestudiante;
    private Date fecha;

    public ConstanciaFacadeLocal getConstanciaFacade() {
        return constanciaFacade;
    }

    public List<String> getMaterias() {
        return materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public MateriaFacadeLocal getMateriaFacede() {
        return materiaFacede;
    }

    public String getNombreestudiante() {
        return nombreestudiante;
    }

    public void setNombreestudiante(String nombreestudiante) {
        this.nombreestudiante = nombreestudiante;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setMateriaFacede(MateriaFacadeLocal materiaFacede) {
        this.materiaFacede = materiaFacede;
    }

    public void setConstanciaFacade(ConstanciaFacadeLocal constanciaFacade) {
        this.constanciaFacade = constanciaFacade;
    }

    public int getIdconstancia() {
        return idconstancia;
    }

    public void setIdconstancia(int idconstancia) {
        this.idconstancia = idconstancia;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(int idestudiante) {
        this.idestudiante = idestudiante;
    }

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    //metodo que se ejecuta al enviar el formulario de la matricula
    public String guardar() throws IOException {
        byte[] fotoBlob = null;
        if (foto != null) {
                  try (InputStream is = foto.getInputstream()) {
                    fotoBlob = new byte[is.available()];
                    is.read(fotoBlob);
                    is.close();
                }
               
        }
        Constancia c = new Constancia();
        ConstanciaPK pk = new ConstanciaPK(idconstancia, idestudiante);
        Estudiante e = new Estudiante(idestudiante);
        c.setConstanciaPK(pk);
        c.setEstudiante(e);
        e.setNombre(nombreestudiante);
        e.setPrograma(programa);
        e.setFoto(fotoBlob);
        fecha = new Date();
        c.setFecha(fecha);
        c.setSemestre(semestre);
        //se recorre la lista de materias ingresadas para realizar el ingreso a la Base de Datos
        for (String a : materias) {
            String[] aux = a.split("/");
            Materia m = new Materia(aux[0], Integer.parseInt(aux[1]));
            materiaFacede.create(m);
        }
        this.estudianteFacade.create(e);
        this.constanciaFacade.create(c);
        return "Matricula Realizada";
    }

    //metodo para agregar la materia ingresada a la lista
    public void add() {
        if (!materias.contains(materia + "/" + creditos)) {
            materias.add(materia + "/" + creditos);
        }
    }
    
    //metodo para limpiar los campos del formulario
    public void clear() {
        materias = new ArrayList<>();
        materia = "";
        creditos = 0;
        nombreestudiante = "";
        programa = "";

        idconstancia = 0;
        semestre = 0;
        idestudiante = 0;
        fecha = new Date();

    }

    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    public String getLenguage() {
        return this.locale.getLanguage();
    }

    public void changeLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

    public MatriculaBean() {
    }

}
