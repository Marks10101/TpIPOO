package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-18T13:45:30")
@StaticMetamodel(Proyectos.class)
public class Proyectos_ { 

    public static volatile SingularAttribute<Proyectos, Integer> codigo;
    public static volatile SingularAttribute<Proyectos, Float> monto;
    public static volatile SingularAttribute<Proyectos, Date> fechaInicio;
    public static volatile SingularAttribute<Proyectos, String> nomProyecto;
    public static volatile SingularAttribute<Proyectos, String> integrantes;
    public static volatile SingularAttribute<Proyectos, Date> fechaFinalizacion;

}