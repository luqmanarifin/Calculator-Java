/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

/**
 * RedoCommand adalah kelas yang bertanggungjawab mengeksekusi perintah Redo
 * 
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public class RedoCommand implements CommandInterface {
  /**
   * Default konstruktor
   */
  public RedoCommand() {
    
  }
  /**
   * Method untuk eksekusi
   * @param n parameter integer command
   */
  @Override
  public void execute(int n) {
    System.out.print("Proses Redo " + n + "\n");
  }
}
