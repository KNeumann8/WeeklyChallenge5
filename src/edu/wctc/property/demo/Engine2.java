package edu.wctc.property.demo;

public class Engine2 {

    private int cylinderCount;
    private boolean running;

    public static final int MIN_CYLINDERS = 1;
    public static final int MAX_CYLINDERS = 12;

    public Engine2(int cylinderCount){

        if(cylinderCount<MIN_CYLINDERS||MAX_CYLINDERS>12){
            throw new IllegalArgumentException("Invalid cylinder count.");
        }

        this.cylinderCount = cylinderCount;
        //by default running = false
    }

    public int getCylinderCount(){
        return this.cylinderCount;
    }

    public void start(){
        running = true;
    }

    public void stop(){
        running = false;
    }

    public boolean isRunning() {
        return running;
    }
}
