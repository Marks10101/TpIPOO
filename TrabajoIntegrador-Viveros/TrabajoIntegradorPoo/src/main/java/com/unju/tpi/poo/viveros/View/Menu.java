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
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleados;
import modelo.Proyectos;

/**
 *
 * @author macro
 */
public class Menu {

    public static Scanner scanner = new Scanner(System.in);
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
            System.out.println("________________________________");
            System.out.println("+   Municipalidad de La Quiaca +");
            System.out.println("+==============================+");
            System.out.println("+==== Menu de Admistración ====+");
            System.out.println("+==============================+");
            System.out.println("+   1. Empleados               +");
            System.out.println("+   2. Proyectos               +");
            System.out.println("+   3. Salir                   +");
            System.out.println("+   Ingrese Opcion             +");
            System.out.println("+==============================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:
                    empleados();
                    break;
                case 2:
                    proyectos();
                    break;
                case 3:
                    System.out.println("Saliendo del Programa");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }

    public static void empleados() {

        int opcion = 0;

        while (opcion != 8) {

            System.out.println("____________________________________");
            System.out.println("+    Municipalidad de La Quiaca    +");
            System.out.println("+==================================+");
            System.out.println("+    Menu opciones de Empleados    +");
            System.out.println("+==================================+");
            System.out.println("+   1. Agregar un Empleado         +");
            System.out.println("+   2. Eliminar un Empleado        +");
            System.out.println("+   3. Modificar un Empleado       +");
            System.out.println("+   4. Listar Empleados            +");
            System.out.println("+   5. Empleado de Mayor Edad      +");
            System.out.println("+   6. Empleados con sueldo Basico +");
            System.out.println("+   7. Buscar Empleado             +");
            System.out.println("+   8. Volver                      +");
            System.out.println("+   Ingrese Opcion                 +");
            System.out.println("+==================================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:
                    try {
                        empleado.crearEmpleado();
                    } catch (Exception ex) {
                        System.out.println("Error " + ex);
                    }
                    break;
                case 2:
                    try {
                        empleado.eliminarEmpleado();
                    } catch (Exception ex) {
                        System.out.println("Error " + ex);
                    }
                    break;
                case 3:
                    try {
                        empleado.ModificarEmpleado();
                    } catch (Exception e) {
                        System.out.println("Error " + e);
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
                        System.out.println("Error " + e);
                    }

                    break;
                case 6:
                    System.out.println("Ingrese un sueldo basico:");
                    float suelBasico = scanner.nextFloat();
                    try {
                        empleado.sueldoBasico(suelBasico);
                    } catch (Exception e) {
                        System.out.println("Error " + e);
                    }

                    break;
                case 7:
                    try {
                        empleado.BuscarEmpleado();
                    } catch (Exception ex) {
                        System.out.println("Error " + ex);
                    }
                    break;
                case 8:
                    System.out.println("Volviendo al Menu Admistracion");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }

    public static void proyectos() {
        int opcion = 0;

        while (opcion != 10) {
            System.out.println("________________________________________");
            System.out.println("+      Municipalidad de La Quiaca      +");
            System.out.println("+======================================+");
            System.out.println("+===== Menu opciones de Proyectos =====+");
            System.out.println("+======================================+");
            System.out.println("+   1. Agregar nuevo Proyecto          +");
            System.out.println("+   2. Eliminar un Proyecto            +");
            System.out.println("+   3. Listar Proyectos                +");
            System.out.println("+   4. Agregar empleado a un Proyecto  +");
            System.out.println("+   5. Quitar empleado de un Proyecto  +");
            System.out.println("+   6. Listar empleados de un Proyecto +");
            System.out.println("+   7. Monto total de proyectos        +");
            System.out.println("+   8. Calcular sueldo empleado        +");
            System.out.println("+   9. Listar proyectos por fecha      +");
            System.out.println("+   10. Volver                         +");
            System.out.println("+   Ingrese Opcion                     +");
            System.out.println("+======================================+");

            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Debe ingresar un numero");
            }
            switch (opcion) {
                case 1:
                    try {
                        proyecto.crearProyecto();
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex);
                    }
                    break;
                case 2:
                    try {
                        proyecto.eliminarProyecto();
                    } catch (Exception ex) {
                        System.out.println("Error: " + ex);
                    }
                    break;
                case 3:
                    try {
                        proyecto.mostrarProyectos();
                    } catch (Exception e) {
                        System.out.println("error: " + e.getMessage());
                    }
                    
                    break;
                case 4:
                    System.out.println("Ingrese codigo del proyecto para agregar empleado:");
                    int cod = scanner.nextInt();
                    proyecto = pro.findProyectos(cod);
                    if (proyecto != null) {
                        System.out.println("Ahora ingrese Nro de Legajo del empleado: ");
                        int legajo = scanner.nextInt();
                        if (emp.findEmpleados(legajo) != null) {
                            if (proyecto.comprobarIntegrante(legajo)) {
                                proyecto.addObserver(emp.findEmpleados(legajo));
                                try {
                                    String integrante = proyecto.getIntegrantes() + "" + legajo;
                                    proyecto.setIntegrantes(integrante);
                                    pro.edit(proyecto);
                                } catch (Exception ex) {
                                    System.out.println("Error: " + ex.getMessage());
                                }
                            } else {
                                System.out.println("El empleado ya pertenece a un proyecto");
                            }

                        } else {
                            System.out.println("No existe un empleado con ese Nro de Legajo");
                        }
                    } else {
                        System.out.println("No existe un proyecto con ese Codigo");
                    }

                    break;
                case 5:
                    System.out.println("Ingrese codigo del proyecto para quitar empleado:");
                    cod = scanner.nextInt();
                    proyecto = pro.findProyectos(cod);
                    if (proyecto != null) {
                        System.out.println("Ahora ingrese Nro de Legajo del empleado: ");
                        int legajo = scanner.nextInt();
                        if (emp.findEmpleados(legajo) != null) {
                            proyecto.deleteObserver(emp.findEmpleados(legajo));
                            try {
                                String integrante = proyecto.getIntegrantes();
                                String quitado = proyecto.quitarIntegrantes(integrante, legajo);
                                proyecto.setIntegrantes(quitado);
                                pro.edit(proyecto);
                            } catch (Exception ex) {
                                System.out.println("Error: " + ex.getMessage());
                            }
                        } else {
                            System.out.println("No existe un empleado con ese Nro de Legajo");
                        }
                    } else {
                        System.out.println("No existe un proyecto con ese Codigo");
                    }
                    break;
                case 6:
                    try {
                        proyecto.ListarProyecto();
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                    break;
                case 7:
                    System.out.println("El monto total con el que se cuenta para los proyectos es de: " + proyecto.calcularMontoTotal());
                    break;
                case 8:
                    System.out.println("Ingrese codigo del proyecto:");
                    cod = scanner.nextInt();
                    proyecto = pro.findProyectos(cod);
                    if (proyecto != null) {
                        String cantIntegrantes[] = proyecto.getIntegrantes().split("");
                        List lista = new ArrayList();
                        lista = Arrays.asList(cantIntegrantes);
                        if (lista.get(0) != "") {
                            float montoindividual = proyecto.calcularMontoIndividual(lista.size(), proyecto.getMonto());
                            System.out.println("El monto por empleado del proyecto " + proyecto.getNomProyecto() + " es de " + montoindividual);
                        } else {
                            System.out.println("El proyecto no tiene integrantes");
                        }

                    } else {
                        System.out.println("No existe un proyecto con ese codigo");
                    }
                    break;
                case 9:
                    System.out.println("Entre fecha de Inicio:");
                    System.out.println("dia:");
                    int dia = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("mes:");
                    int mes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("año:");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    Date fechaInicio = new Date(dia, mes, anio);
                    System.out.println("fechaInicio:" + fechaInicio);
                    System.out.println("Y fecha de Finalizacion:");
                    System.out.println("dia:");
                    dia = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("mes:");
                    mes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("año:");
                    anio = scanner.nextInt();
                    scanner.nextLine();
                    Date fechaFinal = new Date(dia, mes, anio);
                    System.out.println("fechaFinal:" + fechaFinal);
                    proyecto.comparaFecha(fechaInicio, fechaFinal);
                    break;
                case 10:
                    System.out.println("Volviendo al Menu Admistracion");
                    break;
                default:
                    System.out.println("Opcion Incorrecta");
                    break;

            }
        }
    }

}
