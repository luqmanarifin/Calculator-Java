/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.CommandProcessor;

import calculator.CommandProcessor.Logger;
import java.io.*;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Luqman A. Siswanto
 */
public class LoggerTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  
  Logger logger = new Logger();
  
  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }
  
  @After
  public void cleanUpStreams() {
    System.setOut(null);
    System.setErr(null);
  }
  
  @Test
  public void undoTest() {
    logger.undo(5);
    Assert.assertEquals("Proses Undo 5", outContent.toString());
  }
  
  @Test
  public void redoTest() {
    logger.redo(5);
    Assert.assertEquals("Proses Redo 5", outContent.toString());
  }
  
  @Test
  public void showMemTest() {
    logger.showMem(5);
    Assert.assertEquals("Proses ShowMem 5", outContent.toString());
  }
  
  @Test
  public void showMemAllTest() {
    logger.showMemAll();
    Assert.assertEquals("Proses Show All", outContent.toString());
  }
}
