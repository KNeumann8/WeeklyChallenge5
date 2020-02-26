package edu.wctc.property.demo;

public class Driver {

    public static void main(String[] args) {

        Engine2 myEngine = new Engine2(8);

        System.out.println("Enter cylinder count.");

        System.out.println("Must be between " + Engine2.MIN_CYLINDERS + " and " + Engine2.MAX_CYLINDERS);


    }

}
