package com.JavaReference.example.multithreading.executorFramework;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {

  private String empName;
  private int empId;
  private Double salary;
  private int noOfDaysWorked;
  private double basicSalary;

  public Employee(String empName, int empId, int noOfDaysWorked, double basicSalary) {
    this.empName = empName;
    this.empId = empId;
    this.noOfDaysWorked = noOfDaysWorked;
    this.basicSalary = basicSalary;
  }

  public void calculateSalary() {
    salary = noOfDaysWorked * basicSalary;
  }
}
