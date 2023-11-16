package com.JavaReference.example.collection;

import com.JavaReference.example.comparableVscomparator.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
  public static void main(String[] args) {

    Map<Integer, Employee> employeeMap = new HashMap<>();

    employeeMap.put(1, new Employee(1, "Rakesh"));
    employeeMap.put(2, new Employee(3, "Dinesh"));
    employeeMap.put(3, new Employee(2, "Mukesh"));
    employeeMap.put(5, new Employee(2, "Mukesh"));
    employeeMap.put(4, new Employee(4, "Ali"));

    // get is used to get the value by passing the key
    // System.out.println(employeeMap.get("2"));

    // To get all the keys of the map as a set
    Set<Integer> keySet = employeeMap.keySet();
    // keySet.stream().forEach((k) -> System.out.println(k));

    // To get all the values of the map as a collection
    Collection<Employee> values = employeeMap.values();
    // values.stream().forEach((v) -> System.out.println(v));

    // entrySet will convert the key-value pairs into a set of entries, then we can iterate over
    // each entry and get the key and value of each entry
    Set<Map.Entry<Integer, Employee>> entries = employeeMap.entrySet();
    // entries.stream().forEach((e) -> System.out.println(e.getKey() + "...." + e.getValue()));

    employeeMap.entrySet().stream().forEach((e) -> System.out.println(e.getKey()+"'''''"+e.getValue()));
  }
}
