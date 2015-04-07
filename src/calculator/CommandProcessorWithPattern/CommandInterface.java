/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

/**
 * Interface Command merupakan <i> interface </i> untuk kelas-kelas yang
 * mengimplementasi Command Interface <br> <br>
 * Interface digunakan supaya ada standardisasi method pada kelas-kelas yang
 * menjadi eksekutor command
 * 
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public interface CommandInterface {
  /**
   * Mengeksekusi perintah
   * @param n parameter eksekutor berupa integer
   */
  void execute(int n);
}
