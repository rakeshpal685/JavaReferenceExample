package com.JavaReference.example.thread;

public class ByExtendingThread extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("This is second thread");
    }
  }
}
