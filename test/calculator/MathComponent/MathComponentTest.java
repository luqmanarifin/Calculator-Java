/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MathComponent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adar
 */
public class MathComponentTest {
    
    public MathComponentTest() {
    }

    /**
     * Test of getSymComp method, of class MathComponent.
     */
    @Test
    public void testGetSymComp() {
        System.out.println("getSymComp");
        MathComponent instance = new MathComponent("2.00");
        String expResult = "2.00";
        String result = instance.getSymComp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOperator method, of class MathComponent.
     */
    @Test
    public void testGetIsOperator() {
        System.out.println("getIsOperator");
        MathComponent instance = new MathComponent("+");
        boolean expResult = true;
        boolean result = instance.getIsOperator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSymComp method, of class MathComponent.
     */
    @Test
    public void testSetSymComp() {
        System.out.println("setSymComp");
        String S = "70";
        MathComponent instance = new MathComponent("+");
        instance.setSymComp(S);
    }

    /**
     * Test of getPrior method, of class MathComponent.
     */
    @Test
    public void testGetPrior() {
        System.out.println("getPrior");
        MathComponent instance = new MathComponent("+");
        int expResult = 9;
        int result = instance.getPrior();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSymComp method, of class MathComponent.
     */
    @Test
    public void testGetSymComp2() {
        System.out.println("getSymComp");
        MathComponent instance = new MathComponent("-9");
        String expResult = "-9";
        String result = instance.getSymComp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOperator method, of class MathComponent.
     */
    @Test
    public void testGetIsOperator2() {
        System.out.println("getIsOperator");
        MathComponent instance = new MathComponent("7019");
        boolean expResult = false;
        boolean result = instance.getIsOperator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSymComp method, of class MathComponent.
     */
    @Test
    public void testSetSymComp2() {
        System.out.println("setSymComp");
        String S = "-9";
        MathComponent instance = new MathComponent("/");
        instance.setSymComp(S);
    }

    /**
     * Test of getPrior method, of class MathComponent.
     */
    @Test
    public void testGetPrior2() {
        System.out.println("getPrior");
        MathComponent instance = new MathComponent("mod");
        int expResult = 10;
        int result = instance.getPrior();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getSymComp method, of class MathComponent.
     */
    @Test
    public void testGetSymComp3() {
        System.out.println("getSymComp");
        MathComponent instance = new MathComponent("not");
        String expResult = "not";
        String result = instance.getSymComp();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsOperator method, of class MathComponent.
     */
    @Test
    public void testGetIsOperator3() {
        System.out.println("getIsOperator");
        MathComponent instance = new MathComponent("TRUE");
        boolean expResult = false;
        boolean result = instance.getIsOperator();
        assertEquals(expResult, result);
    }
}
