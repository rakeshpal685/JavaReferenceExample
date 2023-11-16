package com.JavaReference.example.reflection;

public class App {
  public static void main(String[] args) throws ClassNotFoundException {

    // Here both will give me the class object and i can use it to get details about the class
    Class<App> appClass = App.class;
    Class<?> appClass2 = Class.forName("com.JavaReference.example.reflection.App");

    System.out.println(appClass.getSimpleName());
    System.out.println(appClass2.getSimpleName());
  }
}
