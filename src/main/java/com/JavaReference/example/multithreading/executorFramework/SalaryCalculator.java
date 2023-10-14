package com.JavaReference.example.multithreading.executorFramework;

public class SalaryCalculator implements Runnable {

  Employee employee;

  public SalaryCalculator(Employee employee) {
    this.employee = employee;
  }

  @Override
  public void run() {
    employee.calculateSalary();
    System.out.println(Thread.currentThread().getName());
  }
}
