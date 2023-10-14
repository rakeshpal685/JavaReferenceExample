package com.JavaReference.example.multithreading.executorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
  public static void main(String[] args) {

    // Here I have 6 employee objects and I have to call the calculateSalary() on each object
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("John", 1, 10, 100));
    employeeList.add(new Employee("Ram", 2, 20, 100));
    employeeList.add(new Employee("Dinesh", 3, 30, 100));
    employeeList.add(new Employee("Ali", 4, 10, 1000));
    employeeList.add(new Employee("Rakesh", 5, 10, 200));
    employeeList.add(new Employee("Jacob", 6, 10, 800));

    //    Here I am using try with resources to auto close the Executor service, which have 3
    // threads in the thread pool.
    try (ExecutorService executorService = Executors.newFixedThreadPool(3)) {

      //      Here I am looping through each employee and passing them to the thread pool, so that
      // each thread can call the run method
      for (Employee e : employeeList) {

        /*Here inside every iteration a new thread will be created for the employee object
        Thread thread =
                new Thread(
                        () -> {
                          e.calculateSalary();
                          System.out.println(Thread.currentThread().getName());
                        });
        thread.start();*/

        /* // Here I am creating an implemented class object of runnable and making the employee object
        // available there.
        Runnable runnable = new SalaryCalculator(e);
        // Here I am passing the runnable object so that available threads in the thread pool will
        // call the run method in the implemented class, rather can creating individual threads for
        // each object
        executorService.execute(runnable);*/

        // Simplified version of the above code
        executorService.execute(
            () -> {
              e.calculateSalary();
              System.out.println(Thread.currentThread().getName());
            });
      }
      executorService.shutdown();
    }

    for (Employee e : employeeList) {
      System.out.println(e.getSalary());
    }
  }
}
 /* Here we want to calculate the salary of each employee, can do it in below ways
 1. create objects of employees and call the calculateSalary method on each employee object individually.
 OR
 2.create objects of employees and iterate over them and create a thread by implementing runnable, now pass the runnable reference object to the thread
 and from the run method call the calculateSalary method on each employee object, this will create individual thread for each employee
 OR
 3. create objects of employees and iterate over them and create a thread pool and pass the runnable reference object to the thread pool,in this case
 the threads in the pool will take up the task if they are free rather than creating individual threads for each object.*/
