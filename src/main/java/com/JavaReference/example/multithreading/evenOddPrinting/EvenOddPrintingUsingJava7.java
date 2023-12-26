package com.JavaReference.example.multithreading.evenOddPrinting;

public class EvenOddPrintingUsingJava7 implements Runnable {

  static int count = 1;
  final Object obj;

  public EvenOddPrintingUsingJava7(Object obj) {
    this.obj = obj;
  }

  @Override
  public void run() {

    while (count <= 10) {

      if (count % 2 == 0 && Thread.currentThread().getName().equals("even")) {
        synchronized (obj) {
          System.out.println(
              "Thread name : " + Thread.currentThread().getName() + " , Value: " + count);
          count++;
          try {
            obj.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }

      if (count % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
        synchronized (obj) {
          System.out.println(
              "Thread name : " + Thread.currentThread().getName() + "  , Value: " + count);
          count++;
          obj.notify();
        }
      }
    }
  }
}
