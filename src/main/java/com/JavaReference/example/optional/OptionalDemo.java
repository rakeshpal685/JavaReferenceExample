package com.JavaReference.example.optional;

import com.JavaReference.example.streams.Employee;

import java.util.Optional;

public class OptionalDemo {

  public static void main(String[] args) {

    Employee emp = new Employee(1, null, 30, "Male", "CS", 2022, 100);
   // Employee emp = new Employee(1, "Rakesh", 30, "Male", "CS", 2022, 100);

    //This will give me a NullPointerException because emp.getName is null
    //System.out.println(emp.getName().toLowerCase());

/*      Optional<String> optionalEmployee= Optional.ofNullable(emp.getName());
      //Here i am checking that if the value is there then get the value
      if(optionalEmployee.isPresent()){
      System.out.println(optionalEmployee.get());
      }*/

/*
      //Instead of isPresent and if condition, I can combine both to write ifPresent
      Optional<String> optionalEmployee= Optional.ofNullable(emp.getName());
    // Here i am checking that if the value is there then get the value
    optionalEmployee.ifPresent((e) -> System.out.println(optionalEmployee.get()));
    */

      //Instead of isPresent and if condition, I can combine both to write ifPresent
      Optional<String> optionalEmployee= Optional.ofNullable(emp.getName());
      // Here i am checking that if the value is there then get the value
      optionalEmployee.ifPresentOrElse((e) -> System.out.println(optionalEmployee.get()),()->{throw new IllegalArgumentException("Name not present");});


     /* Optional<String> optionalEmployee= Optional.ofNullable(emp.getName());
    // Here i am checking that if the value is there then get the value
    optionalEmployee.orElseThrow(() -> new IllegalArgumentException("Name not present"));*/
  }
}
