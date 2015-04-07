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
public class ShowMemCommand implements CommandInterface {
  public ShowMemCommand() {
    
  }
  @Override
  public void execute(int n) {
    System.out.println("Proses ShowMem " + n);
  }
}
