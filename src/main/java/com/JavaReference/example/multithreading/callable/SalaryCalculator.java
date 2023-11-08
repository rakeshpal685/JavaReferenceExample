package com.JavaReference.example.multithreading.callable;

import java.util.concurrent.Callable;

public class SalaryCalculator implements Callable<Employee> {

  Employee employee;

  public SalaryCalculator(Employee employee) {
    this.employee = employee;
  }

  @Override
  public Employee call() throws Exception {
    employee.calculateSalary();
    System.out.println(Thread.currentThread().getName());
    return employee;
  }
}
