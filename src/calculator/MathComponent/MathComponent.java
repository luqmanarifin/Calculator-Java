package calculator.MathComponent;

import java.io.*;
import java.lang.*;

/*
 * @class MathComponent
 * @author Ahmad Darmawan (13513096)
 * @version 1.0 
 * @brief Kelas MathComponent menyimpan operator dan operan.
 */

public class MathComponent {
  /* Attribute kumpulan operator number */
  public static final String[] numberOperator = {"mod", "div",   "*",   "/", "+",  "-"};
  /* Attribute kumpulan operator relational */
  public static final String[] relationalOperator = {"<",  "<=",   ">",  ">=", "=", "<>"};
  /* Attribute kumpulan operator logic */
  public static final String[] logicOperator = {"not", "and", "xor", "or"};
  
  /**
  * @brief Konstruktor kelas MathComponent dengan Parameter.
  * @param S - String yang menjadi anggota MathComponent.
  **/
  
  public MathComponent(String S) {
    symComp = S;
    isOperator = identifyComp();
    identifyPrior();
  }

  /**
  * @brief Getter untuk mendapatkan nilai _symToken.
  * @return symComp - string nilai _symToken.
  **/
  public String getSymComp() {
    return symComp;
  }

  /**
  * @brief Getter untuk mendapatkan nilai _isOperator.
  * @return bool - boolean nilai _isOperator.
  **/
  public boolean getIsOperator() {
    return isOperator;
  }

  /**
  * @brief Setter untuk mengubah nilai _symToken.
  * @brief [I.S] String S merupakan simbol MathComponent yang valid.
  * @brief [F.S] Simbol MathComponent akan terset dengan S.
  * @param S - nilai _symToken yang akan dimasukkan.
  **/
  public void setSymComp(String S) {
    symComp = S;
    isOperator = identifyComp();
    identifyPrior();
  }

  /**
  * @brief Getter untuk mendapatkan nilai _prior.
  * @return i - integer nilai _prior.
  **/
  public int getPrior() {
    return prior;
  }

  /**
  * @brief Set nilai _isOperator berdasarkan _symToken.
  * @return bool - nilai _isOperator
  **/
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

  /**
  * @brief Set nilai _prior berdasarkan _symToken (untuk operator).
  * @brief [I.S] Token memiliki simbol MathComponent yang valid.
  * @brief [F.S] Priority MathComponent akan terset berdasarkan simbol MathComponent.
  **/
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