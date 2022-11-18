/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author macro
 */
public class EmpleadosTest {
    
    public EmpleadosTest() {
    }

    /**
     * Test of calcularEdad method, of class Empleados.
     */
    @Test
    public void testCalcularEdad() {
        System.out.println("calcularEdad");
        Date fechaNac = new Date(1997,8,21);
        Empleados instance = new Empleados();
        int expResult = 23;
        int result = instance.calcularEdad(fechaNac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
}
