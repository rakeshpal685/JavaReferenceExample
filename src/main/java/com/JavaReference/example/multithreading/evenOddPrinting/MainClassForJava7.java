package com.JavaReference.example.multithreading.evenOddPrinting;

public class MainClassForJava7 {

  public static void main(String[] args) {
    Object obj = new Object();

    Runnable r1 = new EvenOddPrintingUsingJava7(obj);
    Runnable r2 = new EvenOddPrintingUsingJava7(obj);

    new Thread(r1, "even").start();
    new Thread(r2, "odd").start();
  }
}
