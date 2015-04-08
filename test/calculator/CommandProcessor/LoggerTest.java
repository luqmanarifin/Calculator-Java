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

import static org.junit.Assert.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class LoggerTest {
  
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
  
  public LoggerTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }

  /**
   * Test of undo method, of class Logger.
   */
  @Test
  public void testUndo() {
    Logger instance = new Logger();
    instance.undo(5);
    Assert.assertEquals("Proses Undo 5\n", outContent.toString());
  }
    

  /**
   * Test of redo method, of class Logger.
   */
  @Test
  public void testRedo() {
    Logger instance = new Logger();
    instance.redo(5);
    Assert.assertEquals("Proses Redo 5\n", outContent.toString());
  }

  /**
   * Test of showMem method, of class Logger.
   */
  @Test
  public void testShowMem() {
    Logger instance = new Logger();
    instance.showMem(5);
    Assert.assertEquals("Proses ShowMem 5\n", outContent.toString());
  }

  /**
   * Test of showMemAll method, of class Logger.
   */
  @Test
  public void testShowMemAll() {
    Logger instance = new Logger();
    instance.showMemAll();
    Assert.assertEquals("Proses Show All\n", outContent.toString());
  }
  /**
   * Test of saveToFile method, of class Saver.
   */
  @Test
  public void testSaveToFile() {
    Logger instance = new Logger();
    instance.saveToFile();
    Assert.assertEquals("Proses Save\n" , outContent.toString());
  }
}
