package com.JavaReference.example.streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // Show the duplicate employees
    Set<Employee> uniqueEmployee = new HashSet<>();
    // We know that set.add will return true if the value is not already present and false if the
    // value is present.Hence we will negate
    // so that if the value is not present then it will return true
    Set<Employee> duplicateEmployee =
        employeeList.stream().filter(e -> !uniqueEmployee.add(e)).collect(Collectors.toSet());
    // System.out.println(duplicateEmployee);

    // Sum of the age of all the employees
    double sum = employeeList.stream().mapToInt(n -> n.getAge()).sum();
    // OR
    Integer collect13 = employeeList.stream().collect(Collectors.summingInt(e -> e.getAge()));
    // OR
    // reduce should be put after map
    Optional<Integer> reduce =
        employeeList.stream().map(e -> e.getAge()).reduce((e1, e2) -> e1 + e2);
    // System.out.println(reduce.get());
    // System.out.println(sum);

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

    // get the name of the highest paid employee (we can use the combination of limit() and skip()
    // too
    String s =
        employeeList.stream()
            .sorted((o1, o2) -> (int) -(o1.getSalary() - o2.getSalary()))
            .map(n -> n.getName())
            .findFirst()
            .get();
    // System.out.println(s);

    // get the details of the highest paid employee
    Employee em =
        employeeList.stream()
            .sorted((o1, o2) -> (int) -(o1.getSalary() - o2.getSalary()))
            .findFirst()
            .get();
    // it's better to use ifPresent in optional result, so our code in the last will be...
    // .fineFirst().ifPresent(p->sout(p))
    // System.out.println(em);

    // OR
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

    ////////////////////////////
    // count the number of employees in each department.groupingBy will take 2 parameters, one is
    // function and the other is
    // Collectors
    Map<String, Long> collect5 =
        employeeList.stream()
            .collect(Collectors.groupingBy(n -> n.getDepartment(), Collectors.counting()));

    Set<Map.Entry<String, Long>> entries = collect5.entrySet();
    /*    for (Map.Entry<String, Long> e : entries) {
      // System.out.println(e.getKey() + " " + e.getValue());
    }*/
    // OR
    // entries.stream().forEach((e) -> System.out.println(e.getKey()+"''''''''"+e.getValue()));
    ///////////////////////////////////////////////

    // Total Average salary
    Double collect10 =
        employeeList.stream().collect(Collectors.averagingDouble(e -> e.getSalary()));
    // System.out.println(collect10);

    // OR
    double collect11 =
        employeeList.stream()
            .collect(Collectors.summarizingDouble(e -> e.getSalary()))
            .getAverage();
    // System.out.println(collect11);

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
    // System.out.println(s2);

    // Flat map
    //    Map will return a stream of objects present in a collection,
    //    flatmap will return a stream of collection present in collections
    List<Integer> l1 = Arrays.asList(1, 2);
    List<Integer> l2 = Arrays.asList(2, 4);
    List<Integer> l3 = Arrays.asList(5, 6);

    List<List<Integer>> combinedList = Arrays.asList(l1, l2, l3);
    // Flatmap will create individual streams for each collection, here we have 3 collections, so it
    // will create 3 streams.
    Set<Integer> collect7 =
        combinedList.stream().flatMap(l -> l.stream()).collect(Collectors.toSet());
    // System.out.println(collect7);

    // Here inside flatmap, after I get individual streams I can apply normal streams methods on
    // each stream.
    Set<Integer> collect8 =
        combinedList.stream().flatMap(l -> l.stream().map(n -> n + 20)).collect(Collectors.toSet());
    // System.out.println(collect8);

    Set<Integer> collect9 =
        combinedList.stream().flatMap(l -> l.stream().distinct()).collect(Collectors.toSet());
    // System.out.println(collect9);

    //////////////// MAP////////////////////////

    Map<Integer, com.JavaReference.example.comparableVscomparator.Employee> employeeMap =
        new HashMap<>();

    employeeMap.put(1, new com.JavaReference.example.comparableVscomparator.Employee(1, "Rakesh"));
    employeeMap.put(2, new com.JavaReference.example.comparableVscomparator.Employee(3, "Dinesh"));
    employeeMap.put(3, new com.JavaReference.example.comparableVscomparator.Employee(2, "Mukesh"));
    employeeMap.put(5, new com.JavaReference.example.comparableVscomparator.Employee(2, "Mukesh"));
    employeeMap.put(4, new com.JavaReference.example.comparableVscomparator.Employee(4, "Ali"));

    // AS MAP DOES NOT IMPLEMENT COLLECTION THEN WE CANNOT DIRECTLY OPEN STREAMS ON MAP OBJECT,
    // HENCE WE HAVE TO FIRST HET ENTRYSET AND THEN APPLY STREAMS ON THAT

    // Sorting based on keys
    /* employeeMap.entrySet().stream()
    .sorted(((o1, o2) -> o1.getKey() - o2.getKey()))
    .forEach((e) -> System.out.println(e));*/

    //    OR
    /*employeeMap.entrySet().stream()
    .sorted(Map.Entry.comparingByKey())
    .forEach((k) -> System.out.println(k));*/

    // Reverse sort based on keys
    /*    employeeMap.entrySet().stream()
    .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
    .forEach(System.out::println);*/

    // Sorting based on value
    /* employeeMap.entrySet().stream()
    .sorted(Map.Entry.comparingByValue())
    .forEach((v) -> System.out.println(v));*/

    // Reverse Sorting based on value
    /* employeeMap.entrySet().stream()
    .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
    .forEach((v) -> System.out.println(v));*/

    // Sort the map according to key and get the output as map
    Map<Integer, com.JavaReference.example.comparableVscomparator.Employee> collect12 =
        employeeMap.entrySet().stream()
            .sorted((e1, e2) -> e1.getKey() - e2.getKey())
            .collect(Collectors.toMap(e -> e.getKey(), v -> v.getValue()));
    // System.out.println(collect12);

    // JAVA 9
    // It will take all the elements till the condition is true and neglect everything after it first encounter the false, something like limit
    // employeeList.stream().takeWhile(e -> e.getId() == 6).forEach(System.out::println);

    // It will take all the elements after once it encountered the condition to be true, something like skip
    // employeeList.stream().dropWhile(e -> e.getId() == 50).forEach(System.out::println);

    Stream.iterate(1, i -> i <= 1000, i -> i * 10).forEach(System.out::println);
  }
}
