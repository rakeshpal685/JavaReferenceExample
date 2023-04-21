package com.JavaReference.example.comparableVscomparator;

import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.HashSet;
import java.util.Set;

public class Testing {
  public static void main(String[] args) {

    Set<Employee> employeeSet = new HashSet<>();
    employeeSet.add(new Employee(1, "rakesh"));
    employeeSet.add(new Employee(3, "mukesh"));
    employeeSet.add(new Employee(5, "ali"));
    employeeSet.add(new Employee(2, "john"));
    employeeSet.add(new Employee(4, "abc"));
  }
}
