package com.JavaReference.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class Testing {

  public static void main(String[] args) {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee(5, "ram", 20, "male", "cs", 2012, 100.50));
    employeeList.add(new Employee(3, "sita", 30, "female", "it", 2014, 200.50));
    employeeList.add(new Employee(1, "shyam", 40, "male", "it", 2013, 300.50));
    employeeList.add(new Employee(6, "gita", 60, "female", "cs", 2012, 100.00));
    employeeList.add(new Employee(4, "ali", 50, "male", "it", 2014, 200.50));
    employeeList.add(new Employee(4, "ali", 50, "male", "it", 2014, 200.50));
    employeeList.add(new Employee(2, "patli", 10, "female", "cse", 2015, 3100.50));
    employeeList.add(new Employee(5, "ramu", 19, "male", "cs", 2017, 400.50));
    employeeList.add(new Employee(5, "ramu", 19, "male", "cs", 2017, 400.50));
    employeeList.add(new Employee(5, "anju", 18, "female", "cs", 2017, 900.50));

    //Show the duplicate employees
    Set<Employee> uniqueEmployee=new HashSet<>();
    //We know that set.add will return true if the value is not already present and false if the value is present.Hence we will negate
    //so that if the value is not present then it will return true
    Set<Employee> duplicateEmployee = employeeList.stream().filter(e -> !uniqueEmployee.add(e)).collect(Collectors.toSet());
    System.out.println(duplicateEmployee);

    // Number of male and female employees
    Map<String, Long> collect =
        employeeList.stream()
            .collect(Collectors.groupingBy(n -> n.getGender(), Collectors.counting()));
    // System.out.println(collect);

    // print the name of all the departments
    Set<String> collect1 =
        employeeList.stream().map(n -> n.getDepartment()).collect(Collectors.toSet());
    // System.out.println(collect1);

    // average age of all the employees
    double average = employeeList.stream().mapToDouble(n -> n.getAge()).average().getAsDouble();
    // System.out.println(average);

    // average age of male and female employees
    Map<String, Double> collect2 =
        employeeList.stream()
            .collect(
                Collectors.groupingBy(
                    n -> n.getGender(), Collectors.averagingInt(n -> n.getAge())));
    // System.out.println(collect2);

    // get the name of the highest paid employee
    String s =
        employeeList.stream()
            .sorted((o1, o2) -> (int) -(o1.getSalary() - o2.getSalary()))
            .map(n -> n.getName())
            .findFirst()
            .get();
    // System.out.println(employee);

    // get the details of the highest paid employee
    Employee collect3 =
        employeeList.stream()
            .collect(Collectors.maxBy((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())))
            .get();
    // System.out.println(collect3);

    // Get the name of all the employees who have joined after 2012.
    List<String> collect4 =
        employeeList.stream()
            .filter(n -> n.getYearOfJoining() > 2012)
            .map(n -> n.getName())
            .collect(Collectors.toList());
    // System.out.println(collect4);

    // count the number of employees in each department.
    Map<String, Long> collect5 =
        employeeList.stream()
            .collect(Collectors.groupingBy(n -> n.getDepartment(), Collectors.counting()));

    Set<Map.Entry<String, Long>> entries = collect5.entrySet();
    for (Map.Entry<String, Long> e : entries) {
      // System.out.println(e.getKey() + " " + e.getValue());
    }

    // Average salary of each department
    Map<String, Double> collect6 =
        employeeList.stream()
            .collect(
                Collectors.groupingBy(
                    n -> n.getDepartment(), Collectors.averagingDouble(n -> n.getSalary())));
    Set<Map.Entry<String, Double>> entries1 = collect6.entrySet();
    for (Map.Entry<String, Double> e : entries1) {
      // System.out.println(e.getKey()+" "+e.getValue());
    }

    // get the details of the youngest male employee in the cs department
    String s1 =
        employeeList.stream()
            .filter(n -> n.getDepartment().equals("cs") && n.getGender().equals("male"))
            .sorted(((o1, o2) -> o1.getAge() - o2.getAge()))
            .map(n -> n.getName())
            .findFirst()
            .get();
    // System.out.println(s1);

    // OR
    String s2 =
        employeeList.stream()
            .filter(n -> n.getDepartment().equals("cs") && n.getGender().equals("male"))
            .min(((o1, o2) -> o1.getAge() - o2.getAge()))
            .map(Employee::getName)
            .get();
    System.out.println(s2);
  }
}
