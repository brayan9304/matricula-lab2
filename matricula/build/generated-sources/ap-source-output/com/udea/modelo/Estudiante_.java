package com.udea.modelo;

import com.udea.modelo.Constancia;
import com.udea.modelo.Materia;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-25T15:57:50")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, Integer> idestudiante;
    public static volatile SingularAttribute<Estudiante, String> programa;
    public static volatile ListAttribute<Estudiante, Materia> materiaCollection;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile ListAttribute<Estudiante, Constancia> constanciaCollection;

}