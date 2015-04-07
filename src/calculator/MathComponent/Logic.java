/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathComponent;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class Logic extends MathComponent {
  public Logic() {
    super("FALSE");
    logic = 0;
  }

  public Logic(String s) {
    super(s);
    logic = toInt(s);
  }

  public int getLogic() {
    return logic;
  }

  public void setLogic(int i) {
    logic = i;
  }

  public Logic notOperation() {
    return (new Logic(toString(~logic)));
  }

  public Logic andOperation(Logic L) {
    return (new Logic(toString(logic & L.logic)));
  }

  public Logic orOperation(Logic L) {
    return (new Logic(toString(logic | L.logic)));
  }

  public Logic xorOperation(Logic L) {
    return (new Logic(toString((logic) ^ (L.logic))));
  }
  
  public int toInt(String s) {
    if(s.equals("FALSE") || s.equals("false"))
    return 0;
    return 1;
  }

  public String toString(int n) {
    String ret;
    if(n == 1)
      ret = (String) "TRUE";
    else
     ret = (String) "FALSE";
    return ret;
  }
  
  private int logic;
}
