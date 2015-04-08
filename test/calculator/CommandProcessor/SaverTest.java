/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessor;

import java.io.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Luqman A. Siswanto
 */
public class SaverTest {
  
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  
  public SaverTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
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

  /**
   * Test of saveToFile method, of class Saver.
   */
  @Test
  public void testSaveToFile() {
    Saver instance = new Saver();
    instance.saveToFile();
    Assert.assertEquals("Proses Save\n" , outContent.toString());
  }
}
