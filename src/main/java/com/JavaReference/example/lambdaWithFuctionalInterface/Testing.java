package com.JavaReference.example.lambdaWithFuctionalInterface;

import java.sql.SQLOutput;

public class Testing implements Interf1 {

  public static void main(String[] args) {

    /*First way to call an interface override method is by providing the implementation in the class
    Testing testing = new Testing();
     testing.m1();*/

    /*Second way to call an interface method by providing inner class implementation
    Interf1 interf1 =
        new Interf1() {
          @Override
          public void m1() {
            System.out.println("Interface implemented method way 2");
          }
        };
    interf1.m1();*/

    /*Third way of providing interface implementation by using lambda expression
    Interf1 interf11 = () -> System.out.println("Interface implemented method way 3");
    interf11.m1();*/
  }

  @Override
  public void m1() {
    System.out.println("Interface implemented method way 1");
  }
}
