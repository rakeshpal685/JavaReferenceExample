package com.JavaReference.example.string;

public class ReverseString {

  public static void main(String[] args) {

    String string = "Rakesh";
    // Simplest way
    StringBuffer stringBuffer = new StringBuffer(string);
    // System.out.println(stringBuffer.reverse());


    // Own logic
    StringBuffer buffer = new StringBuffer();
    for (int i = string.length() - 1; i >= 0; i--) {
      buffer.append(string.charAt(i));
    }
    System.out.println(buffer);
  }
}
