package com.product;

public class Product {

  private int prodNo;
  private String prodName;
  private double prodPrice;

  public Product(int prodNo, String prodName, double prodPrice) {
    super();
    this.prodNo = prodNo;
    this.prodName = prodName;
    this.prodPrice = prodPrice;
  }

  @Override
  public String toString() {
    return "ProdNo=" + prodNo + ", ProdName=" + prodName + ", ProdPrice=" + prodPrice;
  }

  public int getProdNo() {
    return prodNo;
  }

  public void setProdNo(int prodNo) {
    this.prodNo = prodNo;
  }

  public String getProdName() {
    return prodName;
  }

  public void setProdName(String prodName) {
    this.prodName = prodName;
  }

  public double getProdPrice() {
    return prodPrice;
  }

  public void setProdPrice(double prodPrice) {
    this.prodPrice = prodPrice;
  }
}
