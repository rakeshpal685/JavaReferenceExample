package com.JavaReference.example.multithreading.synchronization;

public class Thread2 extends Thread {
  PrintName printName;
  String str;

  public Thread2(PrintName printName, String str) {
    this.printName = printName;
    this.str = str;
  }

  @Override
  public void run() {
    printName.printTheName(str);
  }
}
