/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.unju.tpi.poo.viveros.View.Menu.emp;
import controlador.EmpleadosJpaController;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JOptionPane;

/**
 *
 * @author macro
 */
@Entity
@Table(name = "empleados", catalog = "municipalidad_lq", schema = "")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findByNroLegajo", query = "SELECT e FROM Empleados e WHERE e.nroLegajo = :nroLegajo"),
    @NamedQuery(name = "Empleados.findByApellido", query = "SELECT e FROM Empleados e WHERE e.apellido = :apellido"),
    @NamedQuery(name = "Empleados.findByNombre", query = "SELECT e FROM Empleados e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.dni = :dni"),
    @NamedQuery(name = "Empleados.findByFechaNacimiento", query = "SELECT e FROM Empleados e WHERE e.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Empleados.findBySueldoBasico", query = "SELECT e FROM Empleados e WHERE e.sueldoBasico = :sueldoBasico")})

//Este clase es el observador a la clase Proyectos
public class Empleados implements Observer, Serializable {

    public static Scanner scanner = new Scanner(System.in);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nro_legajo", nullable = false)
    private Integer nroLegajo;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "dni", nullable = false)
    private int dni;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sueldo_basico", nullable = false)
    private float sueldoBasico;

    public Empleados() {
    }

    public Empleados(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public Empleados(Integer nroLegajo, String apellido, String nombre, int dni, Date fechaNacimiento, float sueldoBasico) {
        this.nroLegajo = nroLegajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoBasico = sueldoBasico;
    }

    public Integer getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(Integer nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nroLegajo != null ? nroLegajo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.nroLegajo == null && other.nroLegajo != null) || (this.nroLegajo != null && !this.nroLegajo.equals(other.nroLegajo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Empleados[ nroLegajo=" + nroLegajo + " ]";
    }

    public void crearEmpleado() {
        int nro_legajo, DNI, dia, mes, anio;
        float sueldo;
        

        nro_legajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nº de Legajo: "));

        if (emp.findEmpleados(nro_legajo) == null) {

            nombre = JOptionPane.showInputDialog("Ingrese Nombre: ");

            apellido = JOptionPane.showInputDialog("Ingrese Apellido: ");

            DNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI: "));

            dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Dia: "));

            mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Mes: "));

            anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Año: "));

            Date fecha = new Date(anio, mes, dia);

            sueldo = Float.parseFloat(JOptionPane.showInputDialog("Ingrese Sueldo_basico"));

            Empleados nuevoEmpleado = new Empleados(nro_legajo, apellido, nombre, DNI, fecha, sueldo);
            try {
                emp.create(nuevoEmpleado);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe empleado con este numero de Legajo");
        }

    }

    public void eliminarEmpleado() {
        boolean igual = false;
        int numLegajo = -1;
        Empleados empleado = new Empleados();

        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI del empleado que desea Eliminar:"));
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        for (int i = 0; i < listaEmpleados.size(); i++) {
            numLegajo = listaEmpleados.get(i).getNroLegajo();
            if (dni == listaEmpleados.get(i).getDni()) {
                igual = true;

            }
        }
        if (igual == true) {
            try {
                emp.destroy(numLegajo);
                JOptionPane.showMessageDialog(null, "Empleado Eliminado con Exito");
            } catch (NonexistentEntityException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
    }

    public int calcularEdad(Date fechaNac) {
        int dia = fechaNac.getDate();
        int mes = fechaNac.getMonth();
        int anio = fechaNac.getYear();
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }

    public void mostrarEmpleados() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        for (Empleados e : listaEmpleados) {
            int dia = e.getFechaNacimiento().getDate();
            int mes = e.getFechaNacimiento().getMonth();
            int anio = e.getFechaNacimiento().getYear();
            String fecha = dia + "-" + mes + "-" + anio;
            listaemp += "            " + e.getNroLegajo() + "             " + "|"
                    + e.getApellido() + "                  " + "|"
                    + e.getNombre() + "                  " + "|"
                    + e.getDni() + "                  " + "|"
                    + fecha + "                  " + "|"
                    + e.getSueldoBasico() + "\n";

        }
        listaemp += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listaemp);
        /*
        String listaemp = ("+--------------------------------------------------------------------------------+\n"
        +"+                                      Lista de Empleados                        +\n"
        +"+--------------------------------------------------------------------------------+\n"
        +"|N° Legajo|    Apellido   |    Nombre      |   DNI    | FecNacimiento |  sueldo  |\n"
        +"+--------------------------------------------------------------------------------+\n");
        for (Empleados e : listaEmpleados){
            int dia = e.getFechaNacimiento().getDate();
            int mes = e.getFechaNacimiento().getMonth();
            int anio = e.getFechaNacimiento().getYear();
            String fecha = dia + "-" + mes + "-" + anio;
            listaemp +="  "+e.getNroLegajo()+"                  "+"|"
                            +e.getApellido()+"                  "+"|"
                            +e.getNombre()+"                  "+"|"
                            +e.getDni()+"                  "+"|"
                            +fecha+"                  "+"|"
                            +e.getSueldoBasico()+"\n";
                    
        }
        JOptionPane.showMessageDialog(null, listaemp);
         */

    }

    public void mayorEdad() {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        Empleados empleado = new Empleados();
        int mayorEmp = 0;
        int edad = 0;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            edad = calcularEdad(listaEmpleados.get(i).getFechaNacimiento());
            if (mayorEmp < edad) {
                mayorEmp = edad;
                empleado = listaEmpleados.get(i);
            }
        }
        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        int dia = empleado.getFechaNacimiento().getDate();
        int mes = empleado.getFechaNacimiento().getMonth();
        int anio = empleado.getFechaNacimiento().getYear();
        String fecha = dia + "-" + mes + "-" + anio;
        listaemp += "            " + empleado.getNroLegajo() + "             " + "|"
                + empleado.getApellido() + "                  " + "|"
                + empleado.getNombre() + "                  " + "|"
                + empleado.getDni() + "                  " + "|"
                + fecha + "                  " + "|"
                + empleado.getSueldoBasico() + "\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+";

        JOptionPane.showMessageDialog(null, listaemp);

    }

    public void sueldoBasico(float suelBasico) {
        EmpleadosJpaController emp = new EmpleadosJpaController();
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();
        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        for (Empleados e : listaEmpleados) {
            {
                if (suelBasico < e.getSueldoBasico()) {
                    int dia = e.getFechaNacimiento().getDate();
                    int mes = e.getFechaNacimiento().getMonth();
                    int anio = e.getFechaNacimiento().getYear();
                    String fecha = dia + "-" + mes + "-" + anio;
                    listaemp += "            " + e.getNroLegajo() + "             " + "|"
                            + e.getApellido() + "                  " + "|"
                            + e.getNombre() + "                  " + "|"
                            + e.getDni() + "                  " + "|"
                            + fecha + "                  " + "|"
                            + e.getSueldoBasico() + "\n";
                }
            }

        }
        listaemp += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listaemp);

    }

    public void ModificarEmpleado() {
        EmpleadosJpaController emp = new EmpleadosJpaController();

        Empleados empleado = new Empleados();

        int nro_legajo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Nº_legajo del Empleado q desea modificar algun dato: "));
        empleado = emp.findEmpleados(nro_legajo);

        int opcion;
        try {
            String menu = JOptionPane.showInputDialog(
                    "+==================================+"
                    + "\n+   1. Modificar Nombre            +"
                    + "\n+   2. Modificar Apellido          +"
                    + "\n+   3. Modificar DNI               +"
                    + "\n+   4. Modificar fecha_nacimiento  +"
                    + "\n+   Ingrese opcion                 +"
                    + "\n+==================================+");
            opcion = Integer.parseInt(menu);

            switch (opcion) {
                case 1:
                    
                    String nombre = JOptionPane.showInputDialog("Ingrese nuevo Nombre:");
                    empleado.setNombre(nombre);
                    break;
                case 2:
                    String apellido = JOptionPane.showInputDialog("Ingrese nuevo Apellido:");
                    empleado.setApellido(apellido);
                    break;
                case 3:
                    int DNI = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo DNI:"));
                    empleado.setDni(DNI);
                    break;
                case 4:
                    int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Dia: "));

                    int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Mes: "));

                    int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha de nacimiento:\n Año: "));
                    Date fecha = new Date(anio, mes, dia);
                    empleado.setFechaNacimiento(fecha);
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion Incorrecta");
                    break;
            }
            try {
                emp.edit(empleado);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Error: " + ex);
            }

        } catch (NumberFormatException e) {
            opcion = 0;
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
        }
    }

    public void BuscarEmpleado() {
        String [] arreglo = {"DNI","APELLIDO"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione por que Buscar", "Buscar", 0,JOptionPane.INFORMATION_MESSAGE,null,arreglo,"" );
        if (arreglo[opcion] == "DNI"){
            
             int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI del empleado que quiere Buscar:"));
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        
         for (Empleados e : listaEmpleados) {
            
        
            if (dni == e.getDni()) {
                int dia =e.getFechaNacimiento().getDate();
                int mes = e.getFechaNacimiento().getMonth();
                int anio = e.getFechaNacimiento().getYear();
                String fecha = dia + "-" + mes + "-" + anio;
                 
                    listaemp += "            " + e.getNroLegajo() + "             " + "|"
                            + e.getApellido() + "                  " + "|"
                            + e.getNombre() + "                  " + "|"
                            + e.getDni() + "                  " + "|"
                            + fecha + "                  " + "|"
                            + e.getSueldoBasico() + "\n";
            }
        }
        listaemp += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listaemp);
        }else{
            if (arreglo[opcion] == "APELLIDO"){
            
            String ape =JOptionPane.showInputDialog("Ingrese Apellido del empleado que quiere Buscar:");
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        
         for (Empleados e : listaEmpleados) {
          
            if (ape == null ? e.getApellido() == null : ape.equals(e.getApellido())) {
                int dia =e.getFechaNacimiento().getDate();
                int mes = e.getFechaNacimiento().getMonth();
                int anio = e.getFechaNacimiento().getYear();
                
                String fecha = dia + "-" + mes + "-" + anio;
                 
                    listaemp += "            " + e.getNroLegajo() + "             " + "|"
                            + e.getApellido() + "                  " + "|"
                            + e.getNombre() + "                  " + "|"
                            + e.getDni() + "                  " + "|"
                            + fecha + "                  " + "|"
                            + e.getSueldoBasico() + "\n";
            }
        }
        listaemp += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listaemp);
        }
        }
       
    }

    public void EmpleadosdeProyecto(List lista) {
        List<Empleados> listaEmpleados = new ArrayList();
        listaEmpleados = emp.findEmpleadosEntities();

        String listaemp
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Empleados                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| N° Legajo |     Apellido    |             Nombre          |             DNI          |       FecNacimiento        |      sueldo     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");
        for (int i = 0; i < lista.size(); i++) {
            String pos = lista.get(i).toString();
            int poss = (Integer.valueOf(pos));
            for (Empleados e : listaEmpleados) {
                if (poss == e.getNroLegajo()) {
                    int dia = e.getFechaNacimiento().getDate();
                    int mes = e.getFechaNacimiento().getMonth();
                    int anio = e.getFechaNacimiento().getYear();
                    String fecha = dia + "-" + mes + "-" + anio;
                    listaemp += "            " + e.getNroLegajo() + "             " + "|"
                            + e.getApellido() + "                  " + "|"
                            + e.getNombre() + "                  " + "|"
                            + e.getDni() + "                  " + "|"
                            + fecha + "                  " + "|"
                            + e.getSueldoBasico() + "\n";
                }
            }

        }
        listaemp += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listaemp);

    }

    //Mensaje de notificacion cuando se asigna un nuevo integrante a un proyecto
    @Override
    public void update(Observable o, Object o1) {
        JOptionPane.showMessageDialog(null,"Se comunica que el proyecto " + ((Proyectos) o).getNomProyecto() + " tiene un nuevo integrante");
        String cantIntegrantes[] = ((Proyectos) o).getIntegrantes().split("");
        List lista = new ArrayList();
        lista = Arrays.asList(cantIntegrantes);
        EmpleadosdeProyecto(lista);
    }
}
