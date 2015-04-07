/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.Equation;


/**
*  EquationException
* @author Wiwit Rifa'i (13513073)
* @version 1.0
* 
*  Description
*  kelas EquationException merupakan kelas mengurusi exception pada equation.
**/
public class EquationException extends Exception {
  private static int num_ex_ = 0;       // banyaknya exception yang telah terjadi.
  private final int msg_id_;        // ID pesan kesalahan.
  private static final String message_[] = {"Angka Romawi hanya diperbolehkan pada batas nilai[1..3999]",
                                      "Tidak diijinkan pembagian dengan nol",
                                      "Tidak diijinkan operasi modulo oleh bilangan non positif",
                                      "Operator yang digunakan tidak terdefinisi",
                                      "Penggunaan operator tidak sesuai",
                                      "Equation kosong, tidak ada yang diselesaikan"
                                     };
  // Konstanta
  /**
  *  konstanta yang menandakan nilai romawi diluar batas [1..3999]
  **/
  public final static int OutOfBoundRomawi       = 0;
  /**
  *  konstanta yang menandakan pembagian dengan nol.
  **/  
  public final static int DivideByZero           = 1;
  /**
  *  konstanta yang menandakan modulo dengan bilangan yang tak positif.
  **/  
  public final static int ModuloByNonPositif     = 2;
  /**
  *  konstanta yang menandakan operator yang tidak diperbolehkan.
  **/  
  public final static int UndefinedOperator      = 3;
  /**
  *  konstanta yang menandakan penggunaan operator yang tidak sesuai.
  **/  
  public final static int IllegalUsingOperator   = 4;
  /**
  *  konstanta yang menandakan program mencoba menyelesaikan Equation kosong.
  **/  
  public final static int EmptyEquation          = 5;
  
  //ctor
  /**
  *  Konstruktor kelas EquationException.
  * @param id menyatakan jenis error yang terjadi.
  **/
  public EquationException(int id) {
    super(message_[id]);
    msg_id_ = id;
    num_ex_++;
  }
  /**
  *  Copy constructor kelas EquationException.
  * @param s EquationException - reference objek yang akan di copy;
  **/
  public EquationException(EquationException s) {
    msg_id_ = s.msg_id_;
  }
  
  //method
  /**
  *  Getter banyaknya exception yang telah terjadi.
  **/  
  public static int getNumOfException() {
    return num_ex_;
  }
  /**
  *  Getter nilai ID kesalahan.
  **/  
  public final int getID() {
    return msg_id_;
  }
  /**
  *  Getter pesan kesalahan.
  **/
  public String getMessage() {
    return message_[msg_id_];
  }
};