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
public class UndoCommandTest {

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
  
  public UndoCommandTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   * Test of execute method, of class UndoCommand.
   */
  @Test
  public void testExecute() {
    UndoCommand instance = new UndoCommand();
    instance.execute(5);
    Assert.assertEquals("Proses Undo 5\n", outContent.toString());
  }
  
}
