/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

/**
 *
 * @author Luqman A. Siswanto
 */
public class RedoCommand implements CommandInterface {
  public RedoCommand() {
    
  }
  @Override
  public void execute(int n) {
    System.out.println("Proses Redo " + n);
  }
}
