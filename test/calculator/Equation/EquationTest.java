/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Equation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author iafir
 */
public class EquationTest {
  
  public EquationTest() {
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
   * Test of getResult method, of class Equation.
   * Test case Infix Number Arab
   */
  @Test
  public void testGetResult1() throws EquationException {
    String s = "(6 + 7) * -2";
    String expResult = "-26";
    System.out.println(s + " = " + expResult);
    Equation instance = new Equation(s);
    String result = instance.getResult();
    assertEquals(expResult, result);
  }
  /**
   * Test of getResult method, of class Equation.
   * Test case Postfix Number Romawi
   */
  @Test
  public void testGetResult2() throws EquationException {
    String s = " IV V + II * VII mod";
    String expResult = "IV";
    System.out.println(s + " = " + expResult);
    Equation instance = new Equation(s);
    String result = instance.getResult();
    assertEquals(expResult, result);
  }
  /**
   * Test of getResult method, of class Equation.
   * Test case Prefix Number Romawi + Relational
   */
  @Test
  public void testGetResult3() throws EquationException {
    String s = " or > IV C >= false true";
    String expResult = "false";
    System.out.println(s + " = " + expResult);
    Equation instance = new Equation(s);
    String result = instance.getResult();
    assertEquals(expResult, result);
  }
  /**
   * Test of getResult method, of class Equation.
   * Test case Prefix Logic
   */
  @Test
  public void testGetResult4() throws EquationException {
    String s = "(not false xor true) or false";
    String expResult = "false";
    System.out.println(s + " = " + expResult);
    Equation instance = new Equation(s);
    String result = instance.getResult();
    assertEquals(expResult, result);
  }
  /**
   * Test of getResult method, of class Equation.
   * Test case Prefix Number arab float
   */
  @Test
  public void testGetResult5() throws EquationException {
    String s = "(5 / 2) * -10 - 90";
    String expResult = "-115.00";
    System.out.println(s + " = " + expResult);
    Equation instance = new Equation(s);
    String result = instance.getResult();
    assertEquals(expResult, result);
  }
  /**
   * Test of solve method, of class Equation.
   */
  @Test
  public void testSolve() throws EquationException {
    System.out.println("solve");
    Equation instance = new Equation("3 5 > xor not false");
    instance.solve();
    assertEquals(instance.getResult(), "true");
  }
  
}
