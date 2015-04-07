/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MathComponent;

import java.io.*;
import java.lang.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class MathComponent {
  public MathComponent(String S) {
    symComp = S;
    isOperator = identifyComp();
    identifyPrior();
  }

  public String getSymComp() {
    return symComp;
  }

  public Boolean getIsOperator() {
    return isOperator;
  }

  public void setSymComp(String S) {
    symComp = S;
    isOperator = identifyComp();
    identifyPrior();
  }

  public int getPrior() {
    return prior;
  }

  private Boolean identifyComp() {
    if (((symComp.charAt(0) == '-') || (symComp.charAt(0) == '+')) && (symComp.length() > 1))
    return false;
  else
    return (symComp.charAt(0) < '0' || symComp.charAt(0) > '9') && (symComp.charAt(0) < 'A' || symComp.charAt(0) > 'Z') && (symComp.charAt(0) < 'a' || symComp.charAt(0) > 'z');
  }

  private void identifyPrior() {
    if (isOperator) {
    /* Prioritas operator relatif berdasarkan http://en.wikipedia.org/wiki/Order_of_operations */
    /* operator number to number */
    if (symComp.equals("*") || symComp.equals("/") || symComp.equals("mod") || symComp.equals("div"))
      prior = 10;
    else if (symComp.equals("+") || symComp.equals("-"))
      prior = 9;
    /* operator number to logic */
    else if (symComp.equals("<") || symComp.equals("<=") || symComp.equals(">") || symComp.equals(">="))
      prior = 8;
    else if (symComp.equals("=") || symComp.equals("<>"))
      prior = 7;
    /* operator logic to logic */
    else if (symComp.equals("not"))
      prior = 6;
    else if (symComp.equals("and"))
      prior = 5;
    else if (symComp.equals("xor"))
      prior = 4;
    else if(symComp.equals("or"))
      prior = 3;
    else
      prior = 2;
    }
    else if(symComp.equals("TRUE") || symComp.equals("FALSE") || symComp.equals("true") || symComp.equals("false")) // a logic
      prior = 0;
    else // a number
      prior = 1;
  }

  private String symComp;
  private Boolean isOperator;
  private int prior;
}
