package com.JavaReference.example.interfaceExample;

public interface Interf2 {
  static void m3() {
    System.out.println("Interf2 static method");
  }

  public void m1();

  default void m2() {
    System.out.println("Interf2 default method");
  }
}
