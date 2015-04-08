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
* @class Logic
* @author Ahmad Darmawan (13513096)
* @version 1.0
* @brief Kelas Logic mengatur perhitungan operasi logika (~, &, ^, |)
**/

public class Logic extends MathComponent {
  
  /**
  * @brief Konstruktor kelas Logic.
  *
  **/
  public Logic() {
    super("false");
    logic = 0;
  }

  /**
  * @brief Konstruktor kelas Logic dengan parameter string.
  * @param s - String berisi nilai logika (TRUE atau FALSE).
  **/
  public Logic(String s) {
    super(s);
    logic = toInt(s);
  }
  
  /**
  * @brief Konstruktor kelas Logic dengan parameter integer.
  * @param b - boolean berisi nilai logika (0 atau 1).
  **/
  public Logic(boolean b) {
    super(b ? "true" : "false");
    logic = b ? 1 : 0;
  }

  /**
  * @brief Getter untuk mendapatkan nilai logic.
  * @return i - integer nilai logic (0 atau 1).
  **/
  public int getLogic() {
    return logic;
  }

  /**
  * @brief Setter untuk mengubah nilai logic.
  * @brief [I.S] integer i terdefinisi (0 atau 1).
  * @brief [F.S] _logic diassign dengan nilai i.
  * @param S - nilai logic yang akan dimasukkan.
  **/
  public void setLogic(int i) {
    logic = i;
  }

  /**
  * @brief Melakukan proses "not" pada nilai logika (~L).
  * @return ~L - Objek Logika akhir.
  **/
  public Logic notOperation() {
    return (new Logic(toString(1 - logic)));
  }

  /**
  * @brief Melakukan proses "and" pada nilai logika (L1 & L2).
  * @param L - Objek Logika kedua.
  * @return AL = L1 & L.
  **/
  public Logic andOperation(Logic L) {
    return (new Logic(toString(logic & L.logic)));
  }

  /**
  * @brief Melakukan proses "or" pada nilai logika (L1 | L2).
  * @param L - Objek Logika kedua.
  * @return AL = L1 | L.
  **/
  public Logic orOperation(Logic L) {
    return (new Logic(toString(logic | L.logic)));
  }

  /**
  * @brief Melakukan proses "xor" pada nilai logika (L1 | L2).
  * @param L - Objek Logika kedua.
  * @return AL = L1 ^ L.
  **/
  public Logic xorOperation(Logic L) {
    return (new Logic(toString((logic) ^ (L.logic))));
  }
  // relasional operation
  
  /**
  * @brief Membandingkan L1 < L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 < L.
  **/
  public Logic isLess (Logic L) {
    return new Logic(logic < L.logic);
  }
  
  /**
  * @brief Membandingkan L1 <= L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 <= L.
  **/
  public Logic isLessOrEqual (Logic L) {
    return new Logic(logic <= L.logic);
  }
  
  /**
  * @brief Membandingkan L1 > L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 > L.
  **/
  public Logic isGreater (Logic L) {
    return new Logic(logic > L.logic);
  }
  
  /**
  * @brief Membandingkan L1 >= L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 >= L.
  **/
  public Logic isGreaterOrEqual(Logic L) {
    return new Logic(logic >= L.logic);
  }
  
  /**
  * @brief Membandingkan L1 == L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 == L.
  **/
  public Logic isEqual (Logic L) {
    return new Logic(logic == L.logic);
  }
  
  /**
  * @brief Membandingkan L1 != L.
  * @param L - Objek Logika kedua.
  * @return AL = L1 != L.
  **/
  public Logic isNotEqual (Logic L) {
    return new Logic(logic != L.logic);
  }
  
  /**
  * @brief Mengubah nilai logika dalam bentuk string (TRUE atau FALSE) menjadi bentuk integer (1 & 0).
  * @brief Prekondisi : string terdefinisi (TRUE atau FALSE)
  * @param s - nilai logika dalam string.
  * @return i - nilai logika dalam integer.
  **/
  public int toInt(String s) {
    if(s.equals("FALSE") || s.equals("false"))
      return 0;
    return 1;
  }

  /**
  * @brief Mengubah nilai logika dalam bentuk bentuk integer (1 & 0) menjadi string (TRUE atau FALSE).
  * @brief Prekondisi : int terdefinisi (0 atau 1)
  * @param n - nilai logika dalam integer.
  * @return S - nilai logika dalam string.
  **/
  public String toString(int n) {
    String ret;
    if(n >= 1)
      ret = (String) "true";
    else
     ret = (String) "false";
    return ret;
  }
  @Override
  public String toString() {
    return (logic >= 1) ? "true" : "false";
  }
  
  /* Data Member */
  private int logic;
}