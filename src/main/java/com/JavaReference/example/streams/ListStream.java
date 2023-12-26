package com.JavaReference.example.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListStream {

  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(5, "ram", 20, "male", "cs", 2012, 100.50));
    employeeList.add(new Employee(3, "sita", 30, "female", "it", 2014, 200.50));
    employeeList.add(new Employee(1, "shyam", 40, "male", "it", 2013, 300.50));

    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student(1, "Rakesh"));
    studentList.add(new Student(2, "Dinesh"));

    // We have to combine both the list
    List<Object> collected =
        Stream.concat(employeeList.stream(), studentList.stream()).toList();

    collected.forEach(System.out::println);
  }
}
