/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.java;

import calculator.CommandProcessorWithPattern.*;
import java.io.*;
import java.lang.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class CalculatorJava {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    //System.out.println("Type 'Help' to show documentation\n");
    String buffer = "";
    do {
      //System.out.print("> ");
      try {
        buffer = reader.readLine();
        CommandProcessor com = new CommandProcessor(buffer);
        if(com.isCommand()) {
          com.executeCommand();
        } else { /*
          try {
            Equation solver = new Equation(buffer);
            System.out.println(solver.getResult());
          } catch(EquationException e) {
            if(e.getID() != EquationException.EmptyEquation) {
              System.println("\nException : " + e.getMessage());
            }
          } */
        }
      } catch(IOException e) {
        
      }
    } while(!buffer.equals("Exit"));
    System.out.close();
  }
  
}
