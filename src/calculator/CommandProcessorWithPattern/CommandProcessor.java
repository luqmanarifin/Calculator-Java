/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.CommandProcessorWithPattern;

import java.util.*;
import java.lang.*;

/**
 *
 * @author Luqman A. Siswanto
 */
public class CommandProcessor {
  static final String[] commands = {"Save",
                                    "Redo",
                                    "Undo",
                                    "Show",
                                    "Help",
                                    "Exit" };
  String command;
  public CommandProcessor() {
    
  }
  public CommandProcessor(String cmd) {
    command = cmd;
  }
  public void executeCommand() {
    CommandInterface redo = new RedoCommand();
    CommandInterface undo = new UndoCommand();
    CommandInterface save = new SaveCommand();
    CommandInterface showMem = new ShowMemCommand();
    CommandInterface showMemAll = new ShowMemAllCommand();
    
    Invoker invoker = new Invoker();
    
    StringTokenizer tokenizer = new StringTokenizer(command);
    String word = tokenizer.nextToken();
    int n = 0;
    if(word.equals(commands[0])) {
      invoker.invoke(save, n);
    } else if(word.equals(commands[1])) {
      n = Integer.parseInt(tokenizer.nextToken());
      invoker.invoke(redo, n);
    } else if(word.equals(commands[2])) {
      n = Integer.parseInt(tokenizer.nextToken());
      invoker.invoke(undo, n);
    } else if(word.equals(commands[3])) {
      word = tokenizer.nextToken();
      try {
        n = Integer.parseInt(tokenizer.nextToken());
        invoker.invoke(showMem, n);
      } catch(Exception e) {
        invoker.invoke(showMemAll, n);
      }
    } else if(word.equals(commands[4])) {
      help();
    } else {
      assert word.equals(commands[5]);
    }
  }
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
  public boolean isCommand() {
    StringTokenizer tokenizer = new StringTokenizer(command);
    String firstWord = tokenizer.nextToken();
    for(String str : commands) {
      if(firstWord.equals(str)) {
        return true;
      }
    }
    return false;
  } 
}
