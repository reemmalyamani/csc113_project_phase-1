import java.Io.*; //this file is not done
import java.util.Scanner;

public class ChechkedExample {
  public static void readFile() {
    try {
      File file = new File ("cakes.txt." );
      Scanner s = new Scanner (file);
      System.out.println (s.next()); // ASK ME ABOUT THIS display what we read from the file
    }
    s.close();
  } 
}
