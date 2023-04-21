package com.JavaReference.example.thread;

public class ByImplementingRunnable implements Runnable {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println("This is runnable thread");
    }
  }
}
