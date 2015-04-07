/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessor;

/**
 *
 * @author Luqman A. Siswanto
 */
public class Logger {
  public Logger() {
  
  }
  public void undo(int n) {
    System.out.println("Proses Undo " + n);
  }
  public void redo(int n) {
    System.out.println("Proses Redo " + n);
  }
  public void showMem(int n) {
    System.out.println("Proses ShowMem " + n);
  }
  public void showMemAll() {
    System.out.println("Proses Show All");
  }
}
