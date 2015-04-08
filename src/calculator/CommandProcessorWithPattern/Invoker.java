/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

/**
 * Invoker adalah class yang bertanggungjawab meng-invoke kelas
 * yang bersesuaian untuk melakukan command
 * 
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public class Invoker {
  /**
   * Default konstruktor
   */
  public Invoker() {
    
  }
  /**
   * Menginvokasi kelas yang bersangkutan untuk melakukan command
   * @param cmd Kelas yang akan melakukan command
   * @param n parameter integer untuk eksekusi (misal Undo n)
   */
  public void invoke(CommandInterface cmd, int n) {
    cmd.execute(n);
  }
}
