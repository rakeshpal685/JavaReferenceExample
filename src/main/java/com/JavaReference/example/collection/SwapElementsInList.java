package com.JavaReference.example.collection;

import java.util.Arrays;
import java.util.List;

public class SwapElementsInList {

  public static void main(String[] args) {

    List<Integer> integerList = Arrays.asList(1, 3, 5, 7, -8);

    System.out.println(integerList);

    /* This is the default method
    Collections.reverse(integerList);
    We can write our own custom method like below,
    Here we will loop till half, else it will again reverse after crossing half, and we will get the original list again,
    After every loop we will increase the head position and decrease the tail position, hence we will do -i for the second
    position.
    */
    for (int i = 0; i < integerList.size() / 2; i++) {
      swapElements(integerList, i, integerList.size() -1 -i);
    }
    System.out.println(integerList);
  }

  private static void swapElements(
      List<Integer> stringList, int firstLocation, int secondLocation) {
    Integer temp = stringList.get(firstLocation);

    stringList.set(firstLocation, stringList.get(secondLocation));
    stringList.set(secondLocation, temp);

  }
}
