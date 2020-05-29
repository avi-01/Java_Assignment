package CopyFile;
import java.io.*;
import java.util.Scanner;



public class CopyFile {
  
  public static void main(String[] args) {
    
    try {
      Scanner sc = new Scanner(System.in);
      FileInputStream fileInputStream;
      FileOutputStream fileOutputStream;
      
      System.out.println("Enter the source file path name :- ");
      String source = sc.nextLine();
      
      File sourceFile =  new File(source);
      
      if(!sourceFile.exists()) {
        System.out.println("The source file does not exists");
        return;
      }
      
      fileInputStream = new FileInputStream(sourceFile);

      System.out.println("Enter the destination file path name :- ");
      String destination = sc.nextLine();
      File destinationFile = new File(destination);
      
      if(!destinationFile.exists()) {
        destinationFile.createNewFile();
        fileOutputStream = new FileOutputStream(destinationFile);
      }
      else {
        System.out.print("Want to Overwrite? (yes/no):- ");
        String overwrite = sc.nextLine();
        
        if(overwrite.equals("no")) {
          fileOutputStream = new FileOutputStream(destinationFile,true);
        }
        else {
          fileOutputStream = new FileOutputStream(destinationFile,false);
        }
      }
      
      int inputByte;
      String content = "";
      
      while((inputByte = fileInputStream.read()) != -1) {
        
        fileOutputStream.write(inputByte);
        
        content += ((char)inputByte);
      }

      System.out.println("File copied successfully:- "+content);
      fileInputStream.close();
      fileOutputStream.close();
      
    
    } catch(IOException e) {
      System.out.println("Error: "+e.getMessage());
    }
    
    
  }
  
  
  public static void ce(Object b) {
    System.out.println(b);
  }
}
