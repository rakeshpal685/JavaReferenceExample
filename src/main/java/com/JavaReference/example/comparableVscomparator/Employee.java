package com.JavaReference.example.comparableVscomparator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {

  private int id;
  private String name;

  @Override
  public int compareTo(Employee e) {
    return -(this.getId() - e.getId());
  }
}
