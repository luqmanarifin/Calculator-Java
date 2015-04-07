/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Equation;

import java.util.Stack;

import calculator.MathComponent.*;

/**
* @class Expression
* @author Wiwit Rifa'i (13513073)
* @version 1.0
* 
* @section Description
* @brief Kelas Expression bertanggung jawab dalam mengolah ekspresi matematika atau logika seperti mengubah string menjadi ekspresi matematika dan mengubah bentuk infix atau postfix menjadi prefix agar bisa dihitung di class Equation.
**/
public class EquationPrefixConverter {
  /**
  * @brief Konstruktor kelas Expression.
  **/
  public EquationPrefixConverter() {
    
  }
  /**
  * @brief Mengubah keterurutan token-token pada stack _stackToken dari ekspresi infix menjadi ekspresi prefix.
  **/
  public static void convertFromInfix(Stack<MathComponent> stackMathComponents_) {
    /* mengubah ekspresi infix menjadi prefix */
    Stack<MathComponent> pre = new Stack<MathComponent>(), opr = new Stack<MathComponent>();
    String stemp = "#";
    while(!stackMathComponents_.empty()) {
      MathComponent t = stackMathComponents_.pop();
      if(t.getIsOperator()) {
        /*
        if(t.getSymComp().equals("not")) {
          char c = stemp[0];
          if((c < '0' || c > '9') && (!stemp.equals("not") || stemp.size()<=1) && (c != '(') && ((c < 'a') || (c > 'z')) && ((c < 'A') || (c > 'Z')) && (c != '~'))
            throw(EquationException(EquationException::IllegalUsingOperator));
        } */
        if(t.getSymComp().equals(")")) {
          opr.push(t);
          continue;
        }
        else if(t.getSymComp().equals("(")) {
          while(!opr.empty())
            if(opr.peek().getSymComp().equals(")")) {
              opr.pop();
              break;
            }
            else {
              pre.push(opr.pop());
            }
          continue;
        }
        while(!opr.empty()) {
          if(t.getPrior() < opr.peek().getPrior()) {
            pre.push(opr.pop());
          }
          else
            break;
        }
        opr.push(t);
      }
      else
        pre.push(t);
      stemp = t.getSymComp();
    }
    while(!opr.empty()) {
      pre.push(opr.pop());
    }
    while(!pre.empty()) {
      stackMathComponents_.push(pre.pop());
    }
  }
  /**
  * @brief Mengubah keterurutan MathComponent-MathComponent pada stack stackMathComponents_ dari ekspresi postfix menjadi ekspresi prefix.
  **/
  public static void convertFromPostfix(Stack<MathComponent> _stackToken) {
    /* mengubah ekspresi postfix menjadi prefix */
    Stack<MathComponent> pre = new Stack<MathComponent>(), stk = new Stack<MathComponent>();
    MathComponent flag = new MathComponent("#");
    while(!_stackToken.empty()) {  
      if(_stackToken.peek().getIsOperator())
        stk.push(_stackToken.peek());
      else {
        pre.push(_stackToken.peek());
        while(!stk.empty() && stk.peek() == flag) {
          stk.pop();
          pre.push(stk.pop());
        }
        stk.push(flag);
      }
      _stackToken.pop();
    }
    while(!pre.empty()) {
      _stackToken.push(pre.pop());
    }
  }
};