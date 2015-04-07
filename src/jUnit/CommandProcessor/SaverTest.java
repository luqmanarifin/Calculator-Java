/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jUnit.CommandProcessor;

import calculator.CommandProcessor.Saver;
import java.io.*;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Luqman A. Siswanto
 */
public class SaverTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  
  Saver saver = new Saver();
  
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
  public void saveTest() {
    saver.saveToFile();
    Assert.assertEquals("Proses Save", outContent.toString());
  }
}
