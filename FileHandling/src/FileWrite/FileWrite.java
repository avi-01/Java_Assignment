package FileWrite;

import java.io.*;
import java.util.Scanner;

public class FileWrite {
  public static void main(String[] args) {

    try {
      Scanner sc = new Scanner(System.in);
      
      File file = new File("letter.txt");
      file.createNewFile();
      
      FileWriter fileWriter = new FileWriter(file);

      System.out.println("Enter the 5 lines to store in file:- ");
      
      for(int i=0;i<5;i++) {
        String s = sc.nextLine();
        fileWriter.write(s+"\n");
      }
      
      System.out.println("Content written to the file.\n");
      fileWriter.close();
      
      FileReader fileReader = new FileReader(file);
      System.out.println("File size:- "+ file.length());
      
      int input;
      while ((input=fileReader.read()) != -1) {
        System.out.print((char) input);
      }
      
      file.delete();
      System.out.println("File deleted succesfully.");
      
      fileReader.close();
      sc.close();
      
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

}
