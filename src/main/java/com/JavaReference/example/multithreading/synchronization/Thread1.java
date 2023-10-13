package com.JavaReference.example.multithreading.synchronization;

public class Thread1 extends Thread {

  PrintName printName;
  String str;

  public Thread1(PrintName printName, String str) {
    this.printName = printName;
    this.str = str;
  }

  @Override
  public void run() {
    printName.printTheName(str);
  }
}
