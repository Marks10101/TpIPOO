/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import static com.unju.tpi.poo.viveros.View.Menu.empleado;
import static com.unju.tpi.poo.viveros.View.Menu.pro;
import static com.unju.tpi.poo.viveros.View.Menu.proyecto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Observable;
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
@Table(name = "proyectos", catalog = "municipalidad_lq", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByCodigo", query = "SELECT p FROM Proyectos p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Proyectos.findByNomProyecto", query = "SELECT p FROM Proyectos p WHERE p.nomProyecto = :nomProyecto"),
    @NamedQuery(name = "Proyectos.findByFechaInicio", query = "SELECT p FROM Proyectos p WHERE p.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Proyectos.findByFechaFinalizacion", query = "SELECT p FROM Proyectos p WHERE p.fechaFinalizacion = :fechaFinalizacion"),
    @NamedQuery(name = "Proyectos.findByMonto", query = "SELECT p FROM Proyectos p WHERE p.monto = :monto"),
    @NamedQuery(name = "Poyectos.findByIntegrantes", query = "SELECT e FROM Proyectos e WHERE e.integrantes = :integrantes")})

//Esta clase es la observada por la clase Empleados
public class Proyectos extends Observable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false)
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "nom_proyecto", nullable = false, length = 50)
    private String nomProyecto;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_finalizacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacion;
    @Basic(optional = false)
    @Column(name = "monto", nullable = false)
    private float monto;
    @Basic(optional = false)
    @Column(name = "integrantes", nullable = false, length = 50)
    private String integrantes;

    public Proyectos() {
    }

    public Proyectos(Integer codigo) {
        this.codigo = codigo;
    }

    public Proyectos(Integer codigo, String nomProyecto, Date fechaInicio, Date fechaFinalizacion, float monto, String integrantes) {
        this.codigo = codigo;
        this.nomProyecto = nomProyecto;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.monto = monto;
        this.integrantes = integrantes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomProyecto() {
        return nomProyecto;
    }

    public void setNomProyecto(String nomProyecto) {
        this.nomProyecto = nomProyecto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getIntegrantes() {
        return integrantes;
    }

    //se notifica a observador(Empleados) que se a hecho un cambio y se notofica a los empleados
    public void setIntegrantes(String integrantes) {
        this.integrantes = integrantes;
        setChanged();
        notifyObservers();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Proyectos[ codigo=" + codigo + " ]";
    }

    public void crearProyecto() {
        int cod, diaIn, mesIn, anioIn, diaFin, mesFin, anioFin;
        float monto;
        String nombre_proyecto, Integrantes;

        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Codigo del Proyecto: "));

        if (pro.findProyectos(cod) == null) {

            nombre_proyecto = JOptionPane.showInputDialog("Ingrese Nombre del proyecto: ");

            diaIn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_inicio del proyecto:\n Dia: "));

            mesIn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_inicio del proyecto:\n Mes: "));

            anioIn = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_inicio del proyecto:\n Año: "));

            Date fechaInicio = new Date(anioIn, mesIn, diaIn);

            diaFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_Finalizacion del proyecto:\n Dia: "));

            mesFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_Finalizacion del proyecto:\n Mes: "));

            anioFin = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Fecha_Finalizacion del proyecto:\n Año: "));
            Date fechaFinalizacion = new Date(anioFin, mesFin, diaFin);

            monto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Monto Presupuestado"));

            Proyectos nuevoProyecto = new Proyectos(cod, nombre_proyecto, fechaInicio, fechaFinalizacion, monto, "");
            JOptionPane.showMessageDialog(null, "Nuevo Proyecto Agregado");
            try {
                pro.create(nuevoProyecto);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un proyecto con este codigo");
        }
    }

    public void eliminarProyecto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingreso codigo del Proyecto: "));
        
        try {
            pro.destroy(codigo);
            JOptionPane.showMessageDialog(null, "Proyecto N° "+ codigo +"Eliminado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
    }

    public void ListarProyecto() {

        int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto :"));
        proyecto = pro.findProyectos(cod);
        if (proyecto != null) {
            String cantIntegrantes[] = proyecto.getIntegrantes().split("");
            List lista = new ArrayList();
            lista = Arrays.asList(cantIntegrantes);
            empleado.EmpleadosdeProyecto(lista);
        } else {
            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese codigo");
        }
    }

    public void ListarProyectos() {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        String listapro
                = ("+-----------------------------------+\n"
                + "+      Lista de Proyectos     +\n"
                + "+-----------------------------------+\n"
                + "| Codigo |      Nombre            |\n"
                + "+-----------------------------------+\n");

        for (Proyectos p : listaProyectos) {
            
            listapro
                    += "        " +p.getCodigo() + "      | "
                    +p.getNomProyecto() + " \n ";
                    
                    
        }
        listapro += "+----------------------------------+";
        JOptionPane.showMessageDialog(null, listapro);

    }
    public void mostrarProyectos() {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        String listapro
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Proyectos                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| Codigo |     Nombre    |             fecInicio          |             fecFinalizacion          |       Monto        |      codIntegrantes     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");

        for (Proyectos p : listaProyectos) {
            int dia = p.getFechaInicio().getDate();
            int mes = p.getFechaInicio().getMonth();
            int anio = p.getFechaInicio().getYear();
            String fechaI = dia + "-" + mes + "-" + anio;
            dia = p.getFechaFinalizacion().getDate();
            mes = p.getFechaFinalizacion().getMonth();
            anio = p.getFechaFinalizacion().getYear();
            String fechaF = dia + "-" + mes + "-" + anio;
            listapro
                    += p.getCodigo() + " | "
                    + p.getNomProyecto() + " | "
                    + fechaI + " | "
                    + fechaF + " | "
                    + p.getMonto() + " | "
                    + p.getIntegrantes() + "\n";
        }
        listapro += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listapro);

    }

    public String quitarIntegrantes(String integrantes, int legajo) {
        int num = -1;
        String result = "";
        String legajoCad = String.valueOf(legajo);
        String cantIntegrantes[] = integrantes.split("");
        List lista = new ArrayList();
        lista = Arrays.asList(cantIntegrantes);
        for (int i = 0; i < lista.size(); i++) {
            String pos = lista.get(i).toString();
            if (pos.equals(legajoCad)) {
            } else {
                result = result + pos;
            }
        }
        return result;
    }

    public boolean comprobarIntegrante(int legajo) {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        String legajoCad = String.valueOf(legajo);
        boolean encontrado = true;

        for (int i = 0; i < listaProyectos.size(); i++) {
            String cantIntegrantes[] = listaProyectos.get(i).getIntegrantes().split("");
            List lista = new ArrayList();
            lista = Arrays.asList(cantIntegrantes);
            for (int j = 0; j < lista.size(); j++) {
                String pos = lista.get(j).toString();
                if (pos.equals(legajoCad)) {
                    encontrado = false;
                }
            }
        }
        return encontrado;
    }

    public float calcularMontoTotal() {
        Proyectos proyecto = new Proyectos();
        float montoTotal = 0;
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();
        for (int i = 0; i < listaProyectos.size(); i++) {
            montoTotal = listaProyectos.get(i).getMonto() + montoTotal;
        }
        return montoTotal;
    }

    public float calcularMontoIndividual(int integrantes, float monto) {
        float montoIndividual = 0;
        montoIndividual = monto / integrantes;
        return montoIndividual;
    }

    public void comparaFecha(Date Inicio, Date Final) {
        List<Proyectos> listaProyectos = new ArrayList();
        listaProyectos = pro.findProyectosEntities();

        String listapro
                = ("+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "+                                                              Lista de Proyectos                                                                                   +\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n"
                + "| Codigo |     Nombre    |             fecInicio          |             fecFinalizacion          |       Monto        |      codIntegrantes     |\n"
                + "+----------------------------------------------------------------------------------------------------------------------------------------+\n");

        for (Proyectos p : listaProyectos) {
            if (Inicio.before(p.getFechaInicio()) && Final.after(p.getFechaFinalizacion())) {
                Proyectos proyecto = p;
                mostrarporFecha(proyecto);
            }
        }
        listapro += "+----------------------------------------------------------------------------------------------------------------------------------------+";
        JOptionPane.showMessageDialog(null, listapro);

    }

    public void mostrarporFecha(Proyectos proyecto) {
        String listapo = "";
        int dia = proyecto.getFechaInicio().getDate();
        int mes = proyecto.getFechaInicio().getMonth();
        int anio = proyecto.getFechaInicio().getYear();
        String fechaI = dia + "-" + mes + "-" + anio;
        dia = proyecto.getFechaFinalizacion().getDate();
        mes = proyecto.getFechaFinalizacion().getMonth();
        anio = proyecto.getFechaFinalizacion().getYear();
        String fechaF = dia + "-" + mes + "-" + anio;
     
        listapo +=  
                +proyecto.getCodigo()+
                proyecto.getNomProyecto()+
                fechaI+
                fechaF+
                proyecto.getMonto()+
                proyecto.getIntegrantes() + " |";
       
    }
}
