/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessor;

import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * Command Processor adalah kelas yang bertanggung-jawab memproses command
 * @author Luqman A. Siswanto
 * @version 1.0
 */
public class CommandProcessor {
  private String sentence;
  private Saver saver;
  private Logger logger;
  static final String[] commands = {"Save",
                                    "Redo",
                                    "Undo",
                                    "Show",
                                    "Help",
                                    "Exit" };
  /**
   * Konstruktor default CommandProcessor
   */
  public CommandProcessor() {
    saver = new Saver();
    logger = new Logger();
    sentence = "";
  }
  /**
   * Konstruktor CommandProcessor dengan parameter
   * @param str String yang akan diproses CommandProcessor
   */
  public CommandProcessor(String str) {
    saver = new Saver();
    logger = new Logger();
    sentence = str;
  }
  /**
   * Prekondisi : data member sentence selalu termasuk bagian dari command
   */
  public void executeCommand() {
    StringTokenizer tokenizer = new StringTokenizer(sentence);
    String firstWord = tokenizer.nextToken();
    if(firstWord.equals(commands[0])) {
      save();
    } else if(firstWord.equals(commands[1])) {
      redo();
    } else if(firstWord.equals(commands[2])) {
      undo();
    } else if(firstWord.equals(commands[3])) {
      show();
    } else if(firstWord.equals(commands[4])) {
      help();
    } else {
      assert firstWord.equals(commands[5]);
    }
  }
  /**
   * Melakukan command save
   */
  public void save() {
    saver.saveToFile();
  }
  /**
   * Melakukan command Undo
   */
  public void undo() {
    StringTokenizer tokenizer = new StringTokenizer(sentence);
    tokenizer.nextToken();
    int n = Integer.parseInt(tokenizer.nextToken());
    logger.undo(n);
  }
  /**
   * Melakukan command Redo
   */
  public void redo() {
    StringTokenizer tokenizer = new StringTokenizer(sentence);
    tokenizer.nextToken();
    int n = Integer.parseInt(tokenizer.nextToken());
    logger.redo(n);
  }
   /**
   * Melakukan command Show Mem dan Show All
   */
  public void show() {
    StringTokenizer tokenizer = new StringTokenizer(sentence);
    tokenizer.nextToken();
    try {
      tokenizer.nextToken();
      int n = Integer.parseInt(tokenizer.nextToken());
      logger.showMem(n);
    } catch(Exception e) {
      logger.showMemAll();
    }
  }
  /**
   * Menampilkan command apa saja yang tersedia dalam program Kalkulator
   */
  public void help() {
    System.out.print("\n");
    System.out.print(" Berikut adalah command yang disediakan di program ini.\n\n");
    System.out.print(" Save          : Untuk menyimpan operasi yang pernah dilakukan dalam file");
    System.out.print("                 eksternal. File eksternal akan diminta selanjutnya\n\n");
    System.out.print(" Undo <n>      : Menghapus n buah ekspresi terakhir, <n> adalah bilangan cacah\n\n");
    System.out.print(" Redo <n>      : Mengulang n perintah terakhir\n\n");
    
    System.out.print(" Show Mem <n>  : Menampilkan ekspresi atau perintah terakhir sebanyak n\n");
    System.out.print("                 <n> adalah bilangan cacah\n\n");
    System.out.print(" Show Mem All  : Menampilkan seluruh ekspresi atau perintah yang\n");
    System.out.print("                 pernah dilakukan\n\n");
    System.out.print(" Exit          : Keluar dari command\n\n");
  }
  /**
   * Memeriksa apakah sebuah sentene merupakan command atau tidak
   * @return true bila sentence adalah command, false sebaliknya
   */
  public boolean isCommand() {
    StringTokenizer tokenizer = new StringTokenizer(sentence);
    String firstWord = tokenizer.nextToken();
    for(String str : commands) {
      if(firstWord.equals(str)) {
        return true;
      }
    }
    return false;
  }
}
