package com.springboot.cache;

import java.util.Date;

public class VolatileTest {
    
    /*volatile*/ boolean isRunning = true;
    
    void m(){
        System.out.println("start");
        while (isRunning){
        
        }
        System.out.println("end");
    }
    
    public static void main(String[] args) throws InterruptedException {
        
        VolatileTest test = new VolatileTest();
        
        new Thread(test::m).start();
        
        Thread.sleep(1000);
    
        test.isRunning = false;
        System.out.println("main...end");
        
    }
}
