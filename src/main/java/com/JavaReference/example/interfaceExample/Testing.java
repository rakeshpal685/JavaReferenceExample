package com.JavaReference.example.interfaceExample;

public class Testing implements Interf1, Interf2 {

  public static void main(String[] args) {
    /*    I can call interface static method just like a class static method by
    using interfaceName.staticMethodName.*/
    Interf1.m3();
  }

  /*   Both Interf1 and Interf2 have m1() abstract method, hence just implementing any one of m1()
  will give implementation to both */
  @Override
  public void m1() {
    System.out.println("This satisfies any one implementation");
  }

  @Override
  /*If I want then I can override the default method to give my own implementation or else I can call
  InterfaceName.super.methodName() to use the implementation of the specific interface. */
  public void m2() {
    Interf1.super.m2();
  }
}
