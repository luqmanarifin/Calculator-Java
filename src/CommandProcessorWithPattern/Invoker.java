/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommandProcessorWithPattern;

/**
 *
 * @author Luqman A. Siswanto
 */
public class Invoker {
  public Invoker() {
    
  }
  public void invoke(CommandInterface cmd, int n) {
    cmd.execute(n);
  }
}