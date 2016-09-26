package com.udea.modelo;

import com.udea.modelo.ConstanciaPK;
import com.udea.modelo.Estudiante;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-26T12:32:35")
@StaticMetamodel(Constancia.class)
public class Constancia_ { 

    public static volatile SingularAttribute<Constancia, Estudiante> estudiante;
    public static volatile SingularAttribute<Constancia, ConstanciaPK> constanciaPK;
    public static volatile SingularAttribute<Constancia, Date> fecha;
    public static volatile SingularAttribute<Constancia, Integer> semestre;

}