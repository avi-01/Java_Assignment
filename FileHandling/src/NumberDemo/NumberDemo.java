package NumberDemo;

import java.io.*;
import java.util.Scanner;

public class NumberDemo {

  public static void main(String[] args) {

    try {
      Scanner sc = new Scanner(System.in);

      File number = new File("number.txt");
      File even = new File("even.txt");
      File odd = new File("odd.txt");

      number.createNewFile();
      even.createNewFile();
      odd.createNewFile();

      FileWriter numberOutput = new FileWriter(number);

      System.out.println("Enter 10 numbers to store:- ");

      for (int i = 0; i < 10; i++) {
        int no = sc.nextInt();
        numberOutput.write(no + "\n");
      }

      numberOutput.close();
      
      FileReader numberInput = new FileReader(number);
      BufferedReader numberReader = new BufferedReader(numberInput);
      
      FileWriter evenOutput = new FileWriter(even);
      FileWriter oddOutput = new FileWriter(odd);
      
      System.out.println("The numbers stored are:- ");
      
      String text;
      while((text=numberReader.readLine()) != null) {
        System.out.println(text);
        int num = Integer.parseInt(text);
        
        if(num%2==0) {
          evenOutput.write(num + "\n");
        }
        else {
          oddOutput.write(num + "\n");
        }
      }
      
      numberReader.close();
      numberInput.close();
      evenOutput.close();
      oddOutput.close();
      sc.close();
      
      System.out.println("Number grouped according to even odd");

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }

}
