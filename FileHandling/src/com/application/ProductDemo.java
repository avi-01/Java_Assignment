package com.application;

import java.io.*;
import java.util.Scanner;

import com.product.*;

public class ProductDemo {

  public static void main(String[] args) {

    try {
      Scanner sc = new Scanner(System.in);
      Product products[] = new Product[20];
      int noProducts = 0;

      File productFile = new File("product.txt");

      if (!productFile.exists()) {
        System.out.println("File doesn't exists");
        return;
      }

      FileReader productReader = new FileReader(productFile);
      BufferedReader productBuffer = new BufferedReader(productReader);

      String productLine;

      while ((productLine = productBuffer.readLine()) != null) {

        String productDetails[] = productLine.split(", ");

        Product product = new Product(Integer.parseInt(productDetails[0]), productDetails[1],
            Double.parseDouble(productDetails[2]));

        products[noProducts++] = product;

      }

      productBuffer.close();
      productReader.close();

      System.out.println("Products:- ");
      for (int i = 0; i < noProducts; i++) {
        System.out.println(products[i]);
      }

      double price = 0;
      System.out.println("\n Enter the product price to filter:- ");
      price = sc.nextDouble();

      for (int i = 0; i < noProducts; i++) {
        if (products[i].getProdPrice() < price)
          System.out.println(products[i]);
      }

      String name;
      System.out.println("\n Enter the product name:- ");
      name = sc.nextLine();
      name = sc.nextLine();
      int flag = 0;

      for (int i = 0; i < noProducts; i++) {
        if (products[i].getProdName().equals(name)) {
          flag = 1;
          System.out.println(products[i]);
        }

      }

      if (flag == 0) {
        System.out.println("Product not found");
      }

      System.out.println("\nFile executed successfully");

    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
