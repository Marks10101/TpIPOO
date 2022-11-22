/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unju.tpi.poo.viveros.View;

import controlador.EmpleadosJpaController;
import controlador.ProyectosJpaController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empleados;
import modelo.Proyectos;

/**
 *
 * @author macro
 */
public class Menu {

    public static EmpleadosJpaController emp = new EmpleadosJpaController();
    public static ProyectosJpaController pro = new ProyectosJpaController();
    public static Empleados empleado = new Empleados();
    public static Proyectos proyecto = new Proyectos();

    public static void main(String[] args) {
        menuPrincipal();

    }

    public static void menuPrincipal() {
        int opcion = 0;
        while (opcion != 3) {

            try {

                String menu = JOptionPane.showInputDialog(
                        "*==============================*"
                        + "\n*=== Municipalidad de La Quiaca ====*"
                        + "\n*==============================*"
                        + "\n*===== Menu de Admistración ======*"
                        + "\n*==============================*"
                        + "\n*1. Empleados"
                        + "\n*2. Proyectos"
                        + "\n*3. Salir    "
                        + "\n*=============================*"
                        + "\n*   Ingrese Opcion"
                );
                opcion = Integer.parseInt(menu);

                switch (opcion) {
                    case 1:
                        empleados();
                        break;
                    case 2:
                        proyectos();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saliendo del Programa");

                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                        break;

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
            }
        }
    }

    public static void empleados() {
        int opcion;
        try {

            do {

                String menu = JOptionPane.showInputDialog(
                        "*==============================*"
                        + "\n*=== Municipalidad de La Quiaca ====*"
                        + "\n*==============================*"
                        + "\n*== Menu opciones de Empleados ===*"
                        + "\n*==============================*"
                        + "\n*1. Agregar un Empleado "
                        + "\n*2. Eliminar un Empleado "
                        + "\n*3. Modificar un Empleado   "
                        + "\n*4. Listar Empleados  "
                        + "\n*5. Empleado de Mayor Edad "
                        + "\n*6. Listar empleados que superen determinado sueldo Basico "
                        + "\n*7. Buscar Empleado  "
                        + "\n*8. Volver    "
                        + "\n*=============================*"
                        + "\n*   Ingrese Opcion"
                );
                opcion = Integer.parseInt(menu);

                switch (opcion) {
                    case 1:
                    try {
                        empleado.crearEmpleado();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error " + ex);
                    }
                    break;
                    case 2:
                    try {
                        empleado.eliminarEmpleado();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error " + ex);
                    }
                    break;
                    case 3:
                    try {
                        empleado.ModificarEmpleado();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    }

                    break;
                    case 4:
                    try {
                        empleado.mostrarEmpleados();
                    } catch (Exception e) {
                        System.out.println("Error " + e);
                    }
                    break;
                    case 5:
                    try {
                        empleado.mayorEdad();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error " + e);
                    }

                    break;
                    case 6:
                        float suelBasico = Float.parseFloat(JOptionPane.showInputDialog("Ingrese un sueldo basico:"));

                        try {
                            empleado.sueldoBasico(suelBasico);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Error " + e);
                        }

                        break;
                    case 7:
                     try {
                        empleado.BuscarEmpleado();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error " + ex);
                    }
                    break;
                    case 8:
                        JOptionPane.showMessageDialog(null, "Volviendo al Menu Admistracion");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                        break;

                }

            } while (opcion != 8);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero" + e);
        }
    }

    public static void proyectos() {
        int opcion;
        try {

            do {

                String menu = JOptionPane.showInputDialog(
                        "*==============================*"
                        + "\n*=== Municipalidad de La Quiaca ====*"
                        + "\n*==============================*"
                        + "\n*== Menu opciones de Proyectos ===*"
                        + "\n*==============================*"
                        + "\n*1. Agregar nuevo Proyecto  "
                        + "\n*2. Eliminar un Proyecto "
                        + "\n*3. Listar Proyectos   "
                        + "\n*4. Agregar empleado a un Proyecto  "
                        + "\n*5. Quitar empleado de un Proyecto  "
                        + "\n*6. Listar datos de un proyecto: "
                        + "\n*7. Monto total de proyectos"
                        + "\n*8. Calcular sueldo empleado"
                        + "\n*9. Listar proyectos por fecha"
                        + "\n*10. Volver "
                        + "\n*=============================*"
                        + "\n*   Ingrese Opcion"
                );
                opcion = Integer.parseInt(menu);

                switch (opcion) {
                    case 1:
                    try {
                        proyecto.crearProyecto();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex);
                    }
                    break;
                    case 2:
                    try {
                        proyecto.eliminarProyecto();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error: " + ex);
                    }
                    break;
                    case 3:
                    try {
                        proyecto.ListarProyectos();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "error: " + e.getMessage());
                    }

                    break;
                    case 4:

                        int cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto para agregar empleado:"));
                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {
                            int legajo = Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese Nro de Legajo del empleado: "));

                            if (emp.findEmpleados(legajo) != null) {
                                if (proyecto.comprobarIntegrante(legajo)) {
                                    proyecto.addObserver(emp.findEmpleados(legajo));
                                    try {
                                        String integrante = proyecto.getIntegrantes() + "" + legajo;
                                        proyecto.setIntegrantes(integrante);
                                        pro.edit(proyecto);
                                    } catch (Exception ex) {
                                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El empleado ya pertenece a un proyecto");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "No existe un empleado con ese Nro de Legajo");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese Codigo");
                        }

                        break;
                    case 5:
                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto para quitar empleado:"));
                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {

                            int legajo = Integer.parseInt(JOptionPane.showInputDialog("Ahora ingrese Nro de Legajo del empleado: "));
                            if (emp.findEmpleados(legajo) != null) {
                                proyecto.deleteObserver(emp.findEmpleados(legajo));
                                try {
                                    String integrante = proyecto.getIntegrantes();
                                    String quitado = proyecto.quitarIntegrantes(integrante, legajo);
                                    proyecto.setIntegrantes(quitado);
                                    pro.edit(proyecto);
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No existe un empleado con ese Nro de Legajo");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese Codigo");
                        }
                        break;
                    case 6:
                    try {
                        proyecto.ListarProyecto();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error: " + e);
                    }
                    break;
                    case 7:
                        JOptionPane.showMessageDialog(null, "El monto total con el que se cuenta para los proyectos es de: " + proyecto.calcularMontoTotal());
                        break;
                    case 8:

                        cod = Integer.parseInt(JOptionPane.showInputDialog("Ingrese codigo del proyecto:"));
                        proyecto = pro.findProyectos(cod);
                        if (proyecto != null) {
                            String cantIntegrantes[] = proyecto.getIntegrantes().split("");
                            List lista = new ArrayList();
                            lista = Arrays.asList(cantIntegrantes);
                            if (lista.get(0) != "") {
                                float montoindividual = proyecto.calcularMontoIndividual(lista.size(), proyecto.getMonto());
                                JOptionPane.showMessageDialog(null, "El monto por empleado del proyecto " + proyecto.getNomProyecto() + " es de " + montoindividual);
                            } else {
                                JOptionPane.showMessageDialog(null, "El proyecto no tiene integrantes");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "No existe un proyecto con ese codigo");
                        }
                        break;
                    case 9:
                        //JOptionPane.showMessageDialog(null,"fecha de Inicio:");

                        int dia = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Inicio: \ndia: "));

                        int mes = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Inicio: \n mes:"));

                        int anio = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Inicio: \n año:"));

                        Date fechaInicio = new Date(dia, mes, anio);
                        JOptionPane.showMessageDialog(null, "fechaInicio:" + fechaInicio);

                        //JOptionPane.showMessageDialog(null,"Y fecha de Finalizacion:");
                        dia = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Finalizacion: \ndia: "));

                        mes = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Finalizacion: \n mes:"));

                        anio = Integer.parseInt(JOptionPane.showInputDialog("Entre fecha de Finalizacion: \n año:"));

                        Date fechaFinal = new Date(dia, mes, anio);
                        JOptionPane.showMessageDialog(null, "fechaFinal:" + fechaFinal);
                        proyecto.comparaFecha(fechaInicio, fechaFinal);
                        break;
                    case 10:
                        JOptionPane.showMessageDialog(null, "Volviendo al Menu Admistracion");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
                        break;

                }
            } while (opcion != 10);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero");
        }

    }
}
