package com.JavaReference.example.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {

  public static void main(String[] args) {
    List<String> names = new ArrayList<>();
    names.add("Rakesh");
    names.add("A");
    names.add("PAl");
    names.add("Prakash");
    names.add("ALi");

    // General O/P
    System.out.println(names);

    // Same O/P using StringBuilder
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < names.size(); i++) {
      if (i != (names.size()) - 1) {
        sb.append(names.get(i) + ", ");
      } else {
        sb.append(names.get(i));
      }
    }
    sb.append("]");
    System.out.println(sb);

    // Same can be done using StringJoiner in java8 (This is used when i want to get a string
    // output in a specific format, StringJoiner is immutable

    StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
    /*for (int i = 0; i < names.size(); i++) {
      stringJoiner.add(names.get(i));
    }
    System.out.println(stringJoiner);*/

    // OR
    names.stream().forEach(n -> stringJoiner.add(n));
    System.out.println(stringJoiner);
  }
}
