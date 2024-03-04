package com.JavaReference.example.leetcode;

public class GoodPair {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 1, 1, 3};

    findPair(arr);
  }

  public static void findPair(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = 1; j < arr.length; j++) {
          if(arr[i]==arr[j]){
          System.out.println("(i,j), ");
          }

      }
    }
  }
}
