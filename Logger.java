import java.io.*;

public class Logger {
  public Logger() {
  
  }
  public void undo(int n) {
    System.out.println("Proses Undo " + n);
  }
  public void redo(int n) {
    System.out.println("Proses Redo " + n);
  }
  public void showMem(int n) {
    System.out.println("Proses ShowMem " + n);
  }
  public void showMemAll() {
    System.out.println("Proses ShowMem Semua");
  }
}