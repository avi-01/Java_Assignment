package Employee;

import java.io.*;
import java.util.Scanner;

public class WriteEmployee {

  public static void main(String[] args) {

    try {

      Scanner sc = new Scanner(System.in);

      File emp = new File("emp.txt");
      emp.createNewFile();

      FileOutputStream outputStream = new FileOutputStream(emp);
      ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream);

      System.out.println("Enter the employees details:- No, Name and Basic");
      int no = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      int basic = sc.nextInt();

      Employee employee = new Employee(no, name, basic);

      objectOutput.writeObject(employee);

      objectOutput.close();
      outputStream.close();
      sc.close();

      System.out.println("Employee Detail serialized\n");

      FileInputStream inputStream = new FileInputStream(emp);
      ObjectInputStream objectInput = new ObjectInputStream(inputStream);

      employee = (Employee) objectInput.readObject();
      System.out.println(employee);

      System.out.println("Employee Detail deserialized\n");

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      System.out.println("Error: " + e.getMessage());
    }

  }
}
