package com.JavaReference.example.Interface;

public interface Interf1 {

  static void m3(){
        System.out.println("Interf1 static method");
  }

    public void m1();

    default void m2(){
    System.out.println("Interf1 default method");
  }
}
