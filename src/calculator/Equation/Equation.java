/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Equation;

import java.util.Stack;

import calculator.MathComponent.*;
import calculator.MathComponent.Number;

/**
* @class Equation
* @author Wiwit Rifa'i (13513073)
* @version 1.0
* 
* @section Description
* @brief Kelas Equation bertanggung jawab dalam perhutingan hasil ekspresi 
*        matematika ataupun logika dalam bentuk prefix. Kelas Equation merupakan
*        inheritent dari kelas Expression.
**/
public class Equation {
  /** PREFIX adalah konstanta yang menandakan menggunakan mode prefix */
  private final int EQUATION_PREFIX  = 0;
  /** INFIX adalah konstanta yang menandakan menggunakan mode infix */
  private final int EQUATION_INFIX   = 1;
  /** POSTFIX adalah konstanta yang menandakan menggunakan mode postfix */
  private final int EQUATION_POSTFIX = 2;
  
  /** strEq_ adalah string yang merepresentasikan ekspresi awal */
  private String strEq_;
  /** result_ adalah string yang merepresentasikan hasil dari ekpresi */
  private String result_;
  /** modeEquation_ adalah kode yang merepresentasikan mode operasi yang 
    * digunakan logika ataukah bilangan */
  private int modeEquation_;
  /** stackMathComponents_ menyimpan address dari MathComponent-MathComponent 
    * yang merepresentasikan suatu ekspresi matematika */
  private Stack<MathComponent> stackMathComponents_;
  
  /**
  * @brief Konstruktor kelas Equation.
  **/
  public Equation() {
    
    strEq_        = "";
    result_       = "";
    stackMathComponents_ = new Stack<MathComponent>();
    modeEquation_ = EQUATION_INFIX;
  }
  /**
  * @brief Konstruktor kelas Equation dengan parameter.
  * 
  * @param int strEqin        String yang merepresentasikan ekspresi matematika 
  *                           atau logika yang akan dikelola.
  **/
  public Equation(String strEqin) {
    strEq_               = strEqin;
    result_              = "";
    stackMathComponents_ = new Stack<MathComponent>();
    createMathComponentsFromString();
    if(modeEquation_ == EQUATION_INFIX)
      EquationPrefixConverter.convertFromInfix(stackMathComponents_);
    else if(modeEquation_ == EQUATION_POSTFIX)
      EquationPrefixConverter.convertFromPostfix(stackMathComponents_);
    modeEquation_ = EQUATION_PREFIX;
  }
  /**
  * @brief Mendapatkan hasil perhitungan dari ekspresi
  * 
  * @return String _result - String yang merepresentasikan hasil perhitungan
  **/
  public String getResult() {
    if(result_.length() < 1) {
      try {
        solve();
      } catch(Exception exception) {
        throw exception;
      }
    }
    return result_;
  }
  /**
  * @brief Menghitung hasil ekspresi matematika tersebut
  *        Prekondisi : ekspresi dalam bentuk prefiks
  */
  public void solve() {
    Logic  operanLogic1,  operanLogic2;
    Number operanNumber1, operanNumber2;
    
    MathComponent operator;
    Stack<MathComponent> res = new Stack<MathComponent>();
//    if(stackMathComponents_.empty()) {
//      throw new EquationException(EquationException.EmptyEquation);
//    }
    /*
    System.out.println(stackMathComponents_.size());
    while(!stackMathComponents_.empty()) {
      res.push(stackMathComponents_.pop());
    }
    while(!res.empty()) {
      MathComponent m = res.pop();
      System.out.println("isi stack " + m.getSymComp());
      stackMathComponents_.push(m);
    }
    */
    while(!stackMathComponents_.empty()) {
      operator = stackMathComponents_.pop();
      if(operator.getIsOperator()) {
//        if(res.empty())
//          throw new EquationException(EquationException.IllegalUsingOperator);
        if(operator.getPrior() <= 6) { // hitung logika
          operanLogic1 = (Logic)res.pop();
          
//          if(operanLogic1.getPrior() != 0)
//            throw new EquationException(EquationException.IllegalUsingOperator);
          
          if(operator.getSymComp().equals("not")) {// kasus operator unary negasi
            operanLogic2 = operanLogic1.notOperation();
            res.push(operanLogic2);
            continue;
          }
          
//          if(res.empty())
//            throw new EquationException(EquationException.IllegalUsingOperator);
          operanLogic2 = (Logic)res.pop();
//          if(operanLogic2.getPrior() != 0)
//            throw new EquationException(EquationException.IllegalUsingOperator);
//          try {
            operanLogic1 = CalculateLogic(operanLogic1, operator, operanLogic2);
//          } catch(Exception e) {  
//            throw e;
//          }
          res.push((MathComponent)operanLogic1);
        }
        else if (operator.getPrior() <= 8) {
          MathComponent temp = res.peek();
          if(temp.getPrior() == 0) { // relational operation for logic
            operanLogic1 = (Logic)res.pop();
            
//            if(res.empty())
//              throw new EquationException(EquationException.IllegalUsingOperator);
            operanLogic2 = (Logic)res.pop();
//            if(operanLogic2.getPrior() != 0)
//              throw new EquationException(EquationException.IllegalUsingOperator);
//            try {
              operanLogic1 = CalculateLogic(operanLogic1, operator, operanLogic2);  
//            } catch(Exception e) {  
//              throw e;
//            }
          }
          else { // relational operation for number
            operanNumber1 = (Number)res.pop();
//            if(operanNumber1.getPrior() != 1)
//              throw new EquationException(EquationException.IllegalUsingOperator);
            
//            if(res.empty())
//              throw new EquationException(EquationException.IllegalUsingOperator);
            operanNumber2 = (Number)res.pop();
//            if(operanNumber2.getPrior() != 1)
//              throw new EquationException(EquationException.IllegalUsingOperator);
//            try {
              operanLogic1 = CalculateNumberToLogic(operanNumber1, operator, operanNumber2);  
//            } catch(Exception e) {
//              throw e;
//            }
          }
          res.push((MathComponent)operanLogic1);
        }
        else { // hitung number
          operanNumber1 = (Number)res.pop();
//          if(operanNumber1.getPrior() != 1)
//            throw new EquationException(EquationException.IllegalUsingOperator);
          
//          if(res.empty())
//            throw new EquationException(EquationException.IllegalUsingOperator);
          operanNumber2 = (Number)res.pop();
//          if(operanNumber2.getPrior() != 1)
//            throw new EquationException(EquationException.IllegalUsingOperator);
          
//          try{
            operanNumber1 = CalculateNumber(operanNumber1, operator, operanNumber2);
//          }catch(Exception e) { 
//            throw e;
//          }
          res.push((MathComponent)operanNumber1);
        }
      }
        else
          res.push(operator);
    }
    
    //if(res.size() != 1)
      //throw new EquationException(EquationException.IllegalUsingOperator);
    stackMathComponents_.push((MathComponent)res.peek());
    result_ = res.peek().toString();
  }
  /*
  * @brief Menghitung operasi bilangan yaitu untuk operator (+), (-), (), dan (/).
  * 
  * @param Number operan1 - pointer pada operan bilangan pertama
  * @param MathComponent operator - pointer pada operator bilangan
  * @param Number operan2 - pointer pada operan bilangan kedua
  * @return Number ret - pointer pada bilangan hasil dari operasi
  */
  private Number CalculateNumber(Number operan1, MathComponent operator, Number operan2) {
    Number ret;
    if(operator.getSymComp().equals("*"))
      ret = operan1.kali(operan2);
    else if(operator.getSymComp().equals("/")) {
//      if(operan2.getNilai() == 0)
//        throw new EquationException(EquationException.DivideByZero);
      ret = operan1.bagi(operan2);
    }
    else if(operator.getSymComp().equals("+"))
      ret = operan1.plus(operan2);
    else if(operator.getSymComp().equals("-"))
      ret = operan1.minus(operan2);
    else if(operator.getSymComp().equals("mod")) {
//      if(operan2.getNilai() <= 0)
//        throw new EquationException(EquationException.ModuloByNonPositif);
      ret = operan1.mod(operan2);
    }
    else if(operator.getSymComp().equals("div")) {
//      if(operan2.getNilai() == 0)
//        throw new EquationException(EquationException.DivideByZero);
      ret = operan1.div(operan2);
    }
    else
      ret = new Number();
//      throw new EquationException(EquationException.UndefinedOperator);
    /*
    if(_modeNumber == Extension.RomawiMode && (ret.getNilai() < 1 || ret.getNilai() > 3999))
      throw new EquationException(EquationException.OutOfBoundRomawi);
    */
    return ret;
  }
  /*
  * @brief Menghitung operasi logika yaitu untuk operator (&), (|), dan (^).
  * 
  * @param Logic operan1 - pointer pada operan logika pertama
  * @param MathComponent operator - pointer pada operator logika
  * @param Logic operan2 - pointer pada operan logika kedua
  * @return Logic ret - pointer pada hasil logika dari operasi
  */
  private Logic CalculateLogic(Logic operan1, MathComponent operator, Logic operan2) {
    Logic ret;
    if(operator.getSymComp().equals("and"))
      ret = operan1.andOperation(operan2);
    else if(operator.getSymComp().equals("or"))
      ret = operan1.orOperation(operan2);
    else if(operator.getSymComp().equals("xor"))
      ret = operan1.xorOperation(operan2);
    else if(operator.getSymComp().equals("<"))
      ret = operan1.isLess(operan2);
    else if(operator.getSymComp().equals("<="))
      ret = operan1.isLessOrEqual(operan2);
    else if(operator.getSymComp().equals(">"))
      ret = operan1.isGreater(operan2);
    else if(operator.getSymComp().equals(">="))
      ret = operan1.isGreaterOrEqual(operan2);
    else if(operator.getSymComp().equals("="))
      ret = operan1.isEqual(operan2);
    else if(operator.getSymComp().equals("<>"))
      ret = operan1.isNotEqual(operan2);
    else
      ret = new Logic();
//        throw new EquationException(EquationException.UndefinedOperator);
    return ret;
  }
  /*
  * @brief Menghitung operasi relasional pada bilangan yaitu untuk operator (<), 
  *        (<=), (>), (>=), (=) dan (!=).
  *
  * @param Number operan1 - pointer pada operan bilangan pertama
  * @param MathComponent operator - pointer pada operator relasional
  * @param Number operan2 - pointer pada operan bilangan kedua
  * @return Logic ret - pointer pada hasil logika dari operasi
  */
  private Logic CalculateNumberToLogic(Number operan1, MathComponent operator, Number operan2) {
    Logic ret;
    if(operator.getSymComp().equals("<"))
      ret = operan1.isLess(operan2);
    else if(operator.getSymComp().equals("<="))
      ret = operan1.isLessOrEqual(operan2);
    else if(operator.getSymComp().equals(">"))
      ret = operan1.isGreater(operan2);
    else if(operator.getSymComp().equals(">="))
      ret = operan1.isGreaterOrEqual(operan2);
    else if(operator.getSymComp().equals("="))
      ret = operan1.isEqual(operan2);
    else if(operator.getSymComp().equals("<>"))
      ret = operan1.isNotEqual(operan2);
    else
      ret = new Logic();
//      throw new EquationException(EquationException.UndefinedOperator);
    return ret;
  }
  /*
  * @brief Mengubah string ekspresi dan mengubahnya menjadi token-token yang 
  *        disimpan dalam stack.
  * @param string strEq - string ekspresi yang akan diubah menjadi token-token 
  *                       yang addressnya disimpan dalam stack.
  */
  private void createMathComponentsFromString() {
    strEq_ = strEq_.trim();
    String[] s = strEq_.split("\\s+");
    // Pengecekan MODE EQUATION
    if(s.length > 0) {
      // mode default adalah infix
      modeEquation_ = EQUATION_INFIX;
      // pengecekan jika mode Equation adalah prefix
      for(String opr : MathComponent.numberOperator)
        if(s[0].equals(opr)) {
          modeEquation_ = EQUATION_PREFIX;
          break;
        }
      if(modeEquation_ == EQUATION_INFIX)
        for(String opr : MathComponent.relationalOperator)
          if(s[0].equals(opr)) {
            modeEquation_ = EQUATION_POSTFIX;
            break;
          }
      if(modeEquation_ == EQUATION_INFIX)
        for(int i = 1; i<MathComponent.logicOperator.length; i++)
          if(s[0].equals(MathComponent.logicOperator[i])) {
            modeEquation_ = EQUATION_PREFIX;
            break;
          }
      // pengecekan apakah mode Equation adalah postfix
      if(modeEquation_ == EQUATION_INFIX) {
        String cek = s[s.length-1];
        for(String opr : MathComponent.numberOperator)
          if(cek.equals(opr)) {
            modeEquation_ = EQUATION_POSTFIX;
            break;
          }
        if(modeEquation_ == EQUATION_INFIX)
          for(String opr : MathComponent.relationalOperator)
            if(cek.equals(opr)) {
              modeEquation_ = EQUATION_POSTFIX;
              break;
            }
        if(modeEquation_ == EQUATION_INFIX)
          for(int i = 1; i<MathComponent.logicOperator.length; i++)
            if(cek.equals(MathComponent.logicOperator[i])) {
              modeEquation_ = EQUATION_POSTFIX;
              break;
            }
      }
    }
    // Membuat MathComponent berdasarkan string2 tersebut
    if(modeEquation_ != EQUATION_INFIX) {
      for(int i = 0; i<s.length; i++) {
        MathComponent mathComponent;
        if(s[i].equals("true") ||s[i].equals("TRUE") || s[i].equals("false") || 
           s[i].equals("FALSE") ) {
             mathComponent = new Logic(s[i]);
        }
        else
          mathComponent = new Number(s[i]);
        stackMathComponents_.push(mathComponent);
      }
    }
    else {
      for(int i = 0; i<s.length; i++) {
        int j = 0, k = s[i].length()-1;
        while(j<k && s[i].charAt(j) == '(') {
          stackMathComponents_.push(new MathComponent("("));
          j++;
        }
        while(j<k && s[i].charAt(k) == ')') {
          k--;
        }
        k++;
        if(j<k) {
          String temp = s[i].substring(j, k);
          if( temp.equals("true") ||temp.equals("TRUE") || temp.equals("false") || 
              temp.equals("FALSE") ) {
            stackMathComponents_.push(new Logic(temp));
          }
          else
            stackMathComponents_.push(new Number(temp));
        }
        for(k++; k < s[i].length(); k++)
          stackMathComponents_.push(new MathComponent(")"));
      }
    }
  }
};