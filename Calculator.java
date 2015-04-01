import java.io.*;
import java.lang.*;
import java.util.*;

public class Calculator {
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
    System.out.println("Type 'Help' to show documentation\n");
    String buffer = "";
    do {
      System.out.print("> ");
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