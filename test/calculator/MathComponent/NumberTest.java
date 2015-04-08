/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MathComponent;

import java.io.ByteArrayOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aodyra
 */
public class NumberTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    public NumberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isLess method, of class Number.
     */
    @Test
    public void testIsLess() {
        System.out.println("isLess");
        Number N = new Number("3");
        Number instance = new Number("5");
        Logic expResult = new Logic(false);
        Logic result = instance.isLess(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isLessOrEqual method, of class Number.
     */
    @Test
    public void testIsLessOrEqual() {
        System.out.println("isLessOrEqual");
        Number N = new Number("5");
        Number instance = new Number("3");
        Logic expResult = new Logic(true);
        Logic result = instance.isLessOrEqual(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isGreater method, of class Number.
     */
    @Test
    public void testIsGreater() {
        System.out.println("isGreater");
        Number N = new Number("3");
        Number instance = new Number("5");
        Logic expResult = new Logic(true);
        Logic result = instance.isGreater(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isGreaterOrEqual method, of class Number.
     */
    @Test
    public void testIsGreaterOrEqual() {
        System.out.println("isGreaterOrEqual");
        Number N = new Number("6");
        Number instance = new Number("6");
        Logic expResult = new Logic(true);
        Logic result = instance.isGreaterOrEqual(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isEqual method, of class Number.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Number N = new Number("6");
        Number instance = new Number("7");
        Logic expResult = new Logic(false);
        Logic result = instance.isEqual(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of isNotEqual method, of class Number.
     */
    @Test
    public void testIsNotEqual() {
        System.out.println("isNotEqual");
        Number N = new Number("7");
        Number instance = new Number("7");
        Logic expResult = new Logic(false);
        Logic result = instance.isNotEqual(N);
        assertEquals(expResult.getLogic(), result.getLogic());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of plus method, of class Number.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Number _N = new Number("5");
        Number instance = new Number("5");
        Number expResult = new Number("10");
        Number result = instance.plus(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 10);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of minus method, of class Number.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Number _N = new Number("V");
        Number instance = new Number("VI");
        Number expResult = new Number("1");
        Number result = instance.minus(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of kali method, of class Number.
     */
    @Test
    public void testKali() {
        System.out.println("kali");
        Number _N = new Number("3");
        Number instance = new Number("3");
        Number expResult = new Number("9");
        Number result = instance.kali(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 9);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of bagi method, of class Number.
     */
    @Test
    public void testBagi() {
        System.out.println("bagi");
        Number _N = new Number("6");
        Number instance = new Number("2");
        Number expResult = new Number("3");
        Number result = instance.bagi(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 3);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of div method, of class Number.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Number _N = new Number("5");
        System.out.println(_N.getNilai());
        Number instance = new Number("6");
        Number expResult = new Number("1");
        Number result = instance.div(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of mod method, of class Number.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        Number _N = new Number("5");
        Number instance = new Number("6");
        Number expResult = new Number("1");
        Number result = instance.mod(_N);
        assertEquals(expResult.getNilai(), result.getNilai(), 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getNilai method, of class Number.
     */
    @Test
    public void testGetNilai() {
        System.out.println("getNilai");
        Number instance = new Number("0.0");
        float expResult = 0.0F;
        float result = instance.getNilai();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setNilai method, of class Number.
     */
    @Test
    public void testSetNilai() {
        System.out.println("setNilai");
        float _n = 0.0F;
        Number instance = new Number();
        instance.setNilai(_n);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toInt method, of class Number.
     */
    @Test
    public void testToInt() {
        System.out.println("toInt");
        String s = "I";
        Number instance = new Number("1");
        int expResult = 1;
        int result = instance.toInt(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of toString method, of class Number.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Number instance = new Number("I");
        String expResult = "I";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
