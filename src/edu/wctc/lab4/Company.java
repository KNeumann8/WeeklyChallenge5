package edu.wctc.lab4;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List Employees = new ArrayList();

    private HR hr = new HR();



    public void hireEmployee(String firstName, String lastName, String ssn){
        Employee newHire = new Employee(firstName,lastName,ssn);
        hr.hireEmployee(newHire,Integer.toString(Employees.size() + 1));
        Employees.add(newHire);
    }

}
