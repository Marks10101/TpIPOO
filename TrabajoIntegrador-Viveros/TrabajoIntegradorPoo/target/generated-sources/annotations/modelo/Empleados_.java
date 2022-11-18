package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-18T13:45:30")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Integer> nroLegajo;
    public static volatile SingularAttribute<Empleados, Float> sueldoBasico;
    public static volatile SingularAttribute<Empleados, Date> fechaNacimiento;
    public static volatile SingularAttribute<Empleados, String> apellido;
    public static volatile SingularAttribute<Empleados, String> nombre;
    public static volatile SingularAttribute<Empleados, Integer> dni;

}