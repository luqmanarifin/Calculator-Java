/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MathComponent;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 *
 * @author Ahmad Darmawan
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
  
  public Logic(boolean b) {
    super(b ? "TRUE" : "FALSE");
    logic = b ? 1 : 0;
  }

  public int getLogic() {
    return logic;
  }

  public void setLogic(int i) {
    logic = i;
  }

  public Logic notOperation() {
    return (new Logic(toString(1 - logic)));
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
  // relasional operation
	public Logic isLess (Logic L) {
		return new Logic(logic < L.logic);
	}
	public Logic isLessOrEqual (Logic L) {
		return new Logic(logic <= L.logic);
	}
	public Logic isGreater (Logic L) {
		return new Logic(logic > L.logic);
	}
	public Logic isGreaterOrEqual(Logic L) {
		return new Logic(logic >= L.logic);
	}
	public Logic isEqual (Logic L) {
		return new Logic(logic == L.logic);
	}
	public Logic isNotEqual (Logic L) {
		return new Logic(logic != L.logic);
	}
  
  public int toInt(String s) {
    if(s.equals("FALSE") || s.equals("false"))
      return 0;
    return 1;
  }

  public String toString(int n) {
    String ret;
    if(n >= 1)
      ret = (String) "TRUE";
    else
     ret = (String) "FALSE";
    return ret;
  }
  @Override
  public String toString() {
    return (logic >= 1) ? "TRUE" : "FALSE";
  }
  
  /* Data Member */
  private int logic;
}