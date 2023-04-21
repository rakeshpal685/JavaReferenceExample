package com.JavaReference.example.thread;

public class Testing {

  public static void main(String[] args) {

    /*      First way to start a thread is by extending thread class.
    ByExtendingThread byExtendingThread = new ByExtendingThread();
     byExtendingThread.start();*/

    /*      Second way of starting thread is by implementing Runnable interface
    ByImplementingRunnable byImplementingRunnable = new ByImplementingRunnable();
    Thread thread = new Thread(byImplementingRunnable);
    thread.start();*/

    /*      Third way to start thread is by giving lambda to the runnable interface
    Runnable runnable= ()->{for(int i = 0; i < 5; i++) {
        System.out.println("This is lambda");
    }
        };
      Thread thread1 = new Thread(runnable);
      thread1.start();*/

    for (int i = 0; i < 5; i++) {
      System.out.println("This is main thread");
    }
  }
}
