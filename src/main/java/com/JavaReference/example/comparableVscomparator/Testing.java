package com.JavaReference.example.comparableVscomparator;

import java.util.*;

public class Testing {
  public static void main(String[] args) {

    List<Employee> employeeList = new LinkedList<>();
    employeeList.add(new Employee(1, "rakesh"));
    employeeList.add(new Employee(3, "mukesh"));
    employeeList.add(new Employee(5, "ali"));
    employeeList.add(new Employee(2, "john"));
    employeeList.add(new Employee(4, "abc"));

    // Here if I sort my employee object, it will sort by id, as specified in the Employee class.
    Collections.sort(employeeList);

    /* Here I am dynamically providing the sorting logic using comparator,
     as sort can take comparator as argument and comparator is functional interface, I can directly give implementation
    by lambda*/
    employeeList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

    // System.out.println(employeeList);

    // I can use comparator as an argument to TreeSet because TreeSet sort the elements
    Set<Employee> employeeSet = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));
    employeeSet.add(new Employee(1, "abc"));
    employeeSet.add(new Employee(3, "aaa"));
    employeeSet.add(new Employee(2, "bbb"));

    System.out.println(employeeSet);
  }

  // If wwe use both comparable and comparator together then comparator will have more precedence.
}
