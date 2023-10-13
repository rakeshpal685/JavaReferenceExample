package com.JavaReference.example.multithreading.synchronization;

public class PrintName {

    public void printTheName(String name) {
    for(int i = 0; i <5 ; i++) {
      System.out.println(name);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}
