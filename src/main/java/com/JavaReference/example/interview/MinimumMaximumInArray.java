package com.JavaReference.example.interview;

public class MinimumMaximumInArray {

  public static void main(String[] args) {

    int[] array = {2, 5, 34, 643, 756554, 2};
    int size = 6;
    getValues(array, size);
  }

  static void getValues(int[] a, int n) {

    int min = a[0], max = a[0], currentMin, currentMax;
    for (int i = 0; i < n - 1; i++) {

      /*     First way
      currentMin = Math.min(a[i], a[i + 1]);
      min = (min < currentMin) ? min : currentMin;
      currentMax = Math.max(a[i], a[i + 1]);
      max = (max < currentMax) ? currentMax : max;*/

      if (min > a[i]) {
        min = a[i];
      }
      if (max < a[i]) {
        max = a[i];
      }
    }
    System.out.println("Minimum: " + min + " max: " + max);
  }
}
