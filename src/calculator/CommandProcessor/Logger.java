/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessor;

/**
 * Logger adalah kelas yang bertanggung jawab memproses command yang berurusan dengan memori
 * seperti Undo, Redo, Show Mem, dan Show All
 * 
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public class Logger {
  /**
   * Default konstruktor
   */
  public Logger() {
  
  }
  /**
   * Melakukan eksekusi perintah Undo
   * @param n jumlah perintah yang akan di-Undo
   */
  public void undo(int n) {
    System.out.println("Proses Undo " + n);
  }
  /**
   * Melakukan eksekusi perintah Redo
   * @param n jumlah perintah yang akan di-Redo
   */
  public void redo(int n) {
    System.out.println("Proses Redo " + n);
  }
  /**
   * Melakukan eksekusi perintah Show Mem
   * @param n jumlah perintah yang akan ditampilkan di layar
   */
  public void showMem(int n) {
    System.out.println("Proses ShowMem " + n);
  }
  /**
   * Melakukan eksekusi perintah Show All
   */
  public void showMemAll() {
    System.out.println("Proses Show All");
  }
}
