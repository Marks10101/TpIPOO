/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Observable;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author macro
 */
public class ProyectosTest {
    
    public ProyectosTest() {
    }

    /**
     * Test of calcularMontoIndividual method, of class Proyectos.
     */
    @Test
    public void testCalcularMontoIndividual() {
        System.out.println("calcularMontoIndividual");
        int integrantes = 4;
        float monto = 20000;
        Proyectos instance = new Proyectos();
        float expResult = 4000;
        float result = instance.calcularMontoIndividual(integrantes, monto);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}

