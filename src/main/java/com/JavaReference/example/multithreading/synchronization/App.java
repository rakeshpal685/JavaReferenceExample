package com.JavaReference.example.multithreading.synchronization;

public class App {

  public static void main(String[] args) {
    PrintName printName = new PrintName();

    Thread1 t1 = new Thread1(printName, "Dhoni");
    Thread2 t2 = new Thread2(printName, "Kholi");

    t1.start();
    t2.start();
  }
/*  We can see that both of my threads are simultaneously accessing the same object to call the printTheName() in my PrintName class.Which is causing
  an issue. Similarly, if we have two methods let's say deposit and withdwals, then on the same object we don't know which thread will act first,
   Hence, synchronization is used so that, two threads using the same object can't access the object class methods together, if we make our methods
   synchronized then only one thread which gets the lock of the object first will be able to access the synchronized methods, then the first thread finishes
   and release the lock, then only other thread can access any synchronized method, be it the same method that the previous thread accessed or any
   other synchronized method.*/
}
