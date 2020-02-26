package edu.wctc.method.demo.poor;

public class Dog2 {

    private int age;
    private boolean isGood;

    public Dog2(int age){
        setAge(age);
    }

    public void setGood(boolean good) {
        isGood = good;
    }

    public void setAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("age can't be less than 0");
        }
        this.age = age;
    }

    private void closeGapToMailCarrier(){
        System.out.println("Closing gap.");
    }
    private void startRunning(){
        System.out.println("Running.");
    }
    private void navigateToMailCarrier(){
        System.out.println("Navigating towards mail carrier.");
    }

    public void chaseMailCarrier(){
        startRunning();
        navigateToMailCarrier();
        closeGapToMailCarrier();
    }


}
