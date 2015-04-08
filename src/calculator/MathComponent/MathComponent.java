/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.MathComponent;

import java.io.*;
import java.lang.*;

/**
 *
 * @author Ahmad Darmawan
 */
public class MathComponent {
  public static final String[] numberOperator = {"mod", "div",   "*",   "/", "+",  "-"};
  public static final String[] relationalOperator = {"<",  "<=",   ">",  ">=", "=", "<>"};
  public static final String[] logicOperator = {"not", "and", "xor", "or"};
  public MathComponent(String S) {
    symComp = S;
    isOperator = identifyComp();
    identifyPrior();
  }

  public String getSymComp() {
    return symComp;
  }

  public boolean getIsOperator() {
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

  private boolean identifyComp() {
    for(String s : numberOperator)
      if(symComp.equals(s))
        return true;
    for(String s : relationalOperator)
      if(symComp.equals(s))
        return true;
    for(String s : logicOperator)
      if(symComp.equals(s))
        return true;
    if(symComp.equals("(") || symComp.equals(")"))
      return true;
    return false;
  }

  private void identifyPrior() {
    if (isOperator) {
    /* Prioritas operator relatif berdasarkan http://en.wikipedia.org/wiki/Order_of_operations */
    /* operator number */
    if (symComp.equals(numberOperator[0]) || symComp.equals(numberOperator[1]) ||
        symComp.equals(numberOperator[2]) || symComp.equals(numberOperator[3]))
      prior = 10;
    else if (symComp.equals(numberOperator[4]) || symComp.equals(numberOperator[5]))
      prior = 9;
    /* operator relational */
    else if (symComp.equals(relationalOperator[0]) || symComp.equals(relationalOperator[1]) ||
             symComp.equals(relationalOperator[2]) || symComp.equals(relationalOperator[3]))
      prior = 8;
    else if (symComp.equals(relationalOperator[4]) || symComp.equals(relationalOperator[5]))
      prior = 7;
    /* operator logic */
    else if (symComp.equals(logicOperator[0]))
      prior = 6;
    else if (symComp.equals(logicOperator[1]))
      prior = 5;
    else if (symComp.equals(logicOperator[2]))
      prior = 4;
    else if(symComp.equals(logicOperator[3]))
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
  private boolean isOperator;
  private int prior;
}