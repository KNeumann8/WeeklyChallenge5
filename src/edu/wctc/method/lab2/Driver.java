package edu.wctc.method.lab2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Driver {

    public static void main(String[] args) {

        Employee employee = new Employee("Bob","Ross","111-11-1111");
        System.out.println(employee.getFirstName());

        LocalDate today = LocalDate.now();

        System.out.println(today.toString());



        employee.performNewHireDuties(today,"69"); //add date validation
    }

}
