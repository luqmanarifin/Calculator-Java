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
public class LogicTest {
    
    public LogicTest() {
    }
    

    /**
     * Test of getLogic method, of class Logic.
     */
    @Test
    public void testGetLogic() {
        System.out.println("getLogic");
        Logic instance = new Logic();
        int expResult = 0;
        int result = instance.getLogic();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetLogic1() {
        System.out.println("getLogic");
        Logic instance = new Logic("true");
        int expResult = 1;
        int result = instance.getLogic();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLogic method, of class Logic.
     */
    @Test
    public void testSetLogic() {
        System.out.println("setLogic");
        int i = 0;
        Logic instance = new Logic();
        instance.setLogic(i);
    }

    /**
     * Test of notOperation method, of class Logic.
     */
    @Test
    public void testNotOperation() {
        System.out.println("notOperation");
        Logic instance = new Logic(false);
        Logic expResult = new Logic(true);
        Logic result = instance.notOperation();
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of andOperation method, of class Logic.
     */
    @Test
    public void testAndOperation() {
        System.out.println("andOperation");
        Logic trueL = new Logic(true);
        Logic falseL = new Logic(false);
        Logic expResult1 = new Logic(false);
        Logic result1 = trueL.andOperation(falseL);
        assertEquals(expResult1.getLogic(), result1.getLogic());
        Logic expResult2 = new Logic(false);
        Logic result2 = falseL.andOperation(trueL);
        assertEquals(expResult2.getLogic(), result2.getLogic());
        Logic expResult3 = new Logic(false);
        Logic result3 = falseL.andOperation(falseL);
        assertEquals(expResult3.getLogic(), result3.getLogic());
        Logic expResult4 = new Logic(true);
        Logic result4 = trueL.andOperation(trueL);
        assertEquals(expResult4.getLogic(), result4.getLogic());
    }

    /**
     * Test of orOperation method, of class Logic.
     */
    @Test
    public void testOrOperation() {
        System.out.println("orOperation");
        Logic trueL = new Logic(true);
        Logic falseL = new Logic(false);
        Logic expResult1 = new Logic(true);
        Logic result1 = trueL.orOperation(falseL);
        assertEquals(expResult1.getLogic(), result1.getLogic());
        Logic expResult2 = new Logic(true);
        Logic result2 = falseL.orOperation(trueL);
        assertEquals(expResult2.getLogic(), result2.getLogic());
        Logic expResult3 = new Logic(false);
        Logic result3 = falseL.orOperation(falseL);
        assertEquals(expResult3.getLogic(), result3.getLogic());
        Logic expResult4 = new Logic(true);
        Logic result4 = trueL.orOperation(trueL);
        assertEquals(expResult4.getLogic(), result4.getLogic());
    }

    /**
     * Test of xorOperation method, of class Logic.
     */
    @Test
    public void testXorOperation() {
        System.out.println("xorOperation");
        Logic trueL = new Logic(true);
        Logic falseL = new Logic(false);
        Logic expResult1 = new Logic(true);
        Logic result1 = trueL.xorOperation(falseL);
        assertEquals(expResult1.getLogic(), result1.getLogic());
        Logic expResult2 = new Logic(true);
        Logic result2 = falseL.xorOperation(trueL);
        assertEquals(expResult2.getLogic(), result2.getLogic());
        Logic expResult3 = new Logic(false);
        Logic result3 = falseL.xorOperation(falseL);
        assertEquals(expResult3.getLogic(), result3.getLogic());
        Logic expResult4 = new Logic(false);
        Logic result4 = trueL.xorOperation(trueL);
        assertEquals(expResult4.getLogic(), result4.getLogic());
    }

    /**
     * Test of isLess method, of class Logic.
     */
    @Test
    public void testIsLess() {
        System.out.println("isLess");
        Logic L = new Logic("false");
        Logic instance = new Logic("false");
        Logic expResult = new Logic(false);
        Logic result = instance.isLess(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of isLessOrEqual method, of class Logic.
     */
    @Test
    public void testIsLessOrEqual() {
        System.out.println("isLessOrEqual");
        Logic L = new Logic("false");
        Logic instance = new Logic("false");
        Logic expResult = new Logic(true);
        Logic result = instance.isLessOrEqual(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of isGreater method, of class Logic.
     */
    @Test
    public void testIsGreater() {
        System.out.println("isGreater");
        Logic L = new Logic("true");
        Logic instance = new Logic("false");
        Logic expResult = new Logic(false);
        Logic result = instance.isGreater(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of isGreaterOrEqual method, of class Logic.
     */
    @Test
    public void testIsGreaterOrEqual() {
        System.out.println("isGreaterOrEqual");
        Logic L = new Logic("false");
        Logic instance = new Logic("false");
        Logic expResult = new Logic(true);
        Logic result = instance.isGreaterOrEqual(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of isEqual method, of class Logic.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Logic L = new Logic("false");
        Logic instance = new Logic("false");
        Logic expResult = new Logic(true);
        Logic result = instance.isEqual(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of isNotEqual method, of class Logic.
     */
    @Test
    public void testIsNotEqual() {
        System.out.println("isNotEqual");
        Logic L = new Logic("false");
        Logic instance = new Logic("true");
        Logic expResult = new Logic(true);
        Logic result = instance.isNotEqual(L);
        assertEquals(expResult.getLogic(), result.getLogic());
    }

    /**
     * Test of toInt method, of class Logic.
     */
    @Test
    public void testToInt() {
        System.out.println("toInt");
        String s = "false";
        Logic instance = new Logic();
        int expResult = 0;
        int result = instance.toInt(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Logic.
     */
    @Test
    public void testToString_int() {
        System.out.println("toString");
        int n = 0;
        Logic instance = new Logic();
        String expResult = "false";
        String result = instance.toString(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Logic.
     */
    @Test
    public void testToString_0args() {
        System.out.println("toString");
        Logic instance = new Logic();
        String expResult = "false";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
