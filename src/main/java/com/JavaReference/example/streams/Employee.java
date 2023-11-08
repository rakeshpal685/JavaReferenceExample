package com.JavaReference.example.streams;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Employee implements Comparable<Employee> {
  private int id;
  private String name;
  private int age;
  private String gender;
  private String department;
  private int yearOfJoining;
  private double salary;


  @Override
  public int compareTo(Employee o) {
    return this.getId()-o.getId();
  }
}
