/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class InvokerTest {
  
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }
  
  @After
  public void tearDown() {
    System.setOut(null);
    System.setErr(null);
  }
  
  public InvokerTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   * Test of invoke method, of class Invoker.
   */
  @Test
  public void testInvoke1() {
    CommandInterface redo = new RedoCommand();
    redo.execute(5);
    Assert.assertEquals("Proses Redo 5\n", outContent.toString()); 
  }
  /**
   * Test of invoke method, of class Invoker.
   */
  @Test
  public void testInvoke2() {
    CommandInterface save = new SaveCommand();
    save.execute(5); 
    Assert.assertEquals("Proses Save\n" , outContent.toString());
  }
  /**
   * Test of invoke method, of class Invoker.
   */
  @Test
  public void testInvoke3() {
    CommandInterface showMemAll = new ShowMemAllCommand();
    showMemAll.execute(5);
    Assert.assertEquals("Proses Show All\n", outContent.toString());
  }
  /**
   * Test of invoke method, of class Invoker.
   */
  @Test
  public void testInvoke4() {
    CommandInterface showMem = new ShowMemCommand();
    showMem.execute(5);
    Assert.assertEquals("Proses ShowMem 5\n", outContent.toString());
  }
  /**
   * Test of invoke method, of class Invoker.
   */
  @Test
  public void testInvoke5() {
    CommandInterface undo = new UndoCommand();
    undo.execute(5);
    Assert.assertEquals("Proses Undo 5\n", outContent.toString());
  }
}
