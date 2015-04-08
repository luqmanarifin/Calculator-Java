/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

/**
 * ShowMemAllCommand adalah kelas yang bertanggungjawab mengeksekusi perintah Show All
 * 
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public class ShowMemAllCommand implements CommandInterface {
  /**
   * Default konstruktor
   */
  public ShowMemAllCommand() {
    
  }
  /**
   * Method untuk eksekusi
   * @param n parameter integer command
   */
  @Override
  public void execute(int n) {
    System.out.print("Proses Show All\n");
  }
}
