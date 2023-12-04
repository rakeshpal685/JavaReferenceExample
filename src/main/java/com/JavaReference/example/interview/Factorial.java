package com.JavaReference.example.interview;

public class Factorial {
  public static void main(String[] args) {

    System.out.println(factorialLoop(0));
    System.out.println(factorialRecursion(0));
  }

  // Normal for loop
  static int factorialLoop(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result = result * i;
    }
    return result;
  }

  // Recursion
  static int factorialRecursion(int n) {

    if (n == 0) return 1;
    else return n * factorialRecursion(n - 1);
  }
}
