package com.JavaReference.example.multithreading.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class App {
  public static void main(String[] args) throws ExecutionException, InterruptedException {

    // Here I have 6 employee objects and I have to call the calculateSalary() on each object
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("John", 1, 10, 100));
    employeeList.add(new Employee("Ram", 2, 20, 100));
    employeeList.add(new Employee("Dinesh", 3, 30, 100));
    employeeList.add(new Employee("Ali", 4, 10, 1000));
    employeeList.add(new Employee("Rakesh", 5, 10, 200));
    employeeList.add(new Employee("Jacob", 6, 10, 800));

    List<Future<Employee>> futureList = new ArrayList<>();
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

      for (Employee e : employeeList) {

        /*Here inside every iteration a new thread will be created for the employee object
        Thread thread =
                new Thread(
                        () -> {
                          e.calculateSalary();
                          System.out.println(Thread.currentThread().getName());
                        });
        thread.start();*/

        Callable callable = new SalaryCalculator(e);
        Future<Employee> employeeFuture = executorService.submit(callable);
        futureList.add(employeeFuture);

        // Simplified version of the above code
        /* executorService.execute(
        () -> {
          e.calculateSalary();
          System.out.println(Thread.currentThread().getName());

        });*/
      }
      executorService.shutdown();
    }

    for (Future<Employee> e : futureList) {
      System.out.println(e.get().getSalary());
    }
  }
}
 /* Here we want to calculate the salary of each employee, can do it in below ways
 1. create objects of employees and call the calculateSalary method on each employee object individually.
 OR
 2.create objects of employees and iterate over them and create a thread by implementing callable, now pass the runnable reference object to the thread
 and from the run method call the calculateSalary method on each employee object, this will create individual thread for each employee
 OR
 3. create objects of employees and iterate over them and create a thread pool and pass the runnable reference object to the thread pool,in this case
 the threads in the pool will take up the task if they are free rather than creating individual threads for each object.*/
