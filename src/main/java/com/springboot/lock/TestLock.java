package com.springboot.lock;

import java.util.HashMap;

public class TestLock {
    
    TLock lock = new TLock();
    
    int a = 0;
    
    public void inc(){
        lock.lock();
        try{
            a++;
        }finally {
            lock.unlock();
        }
        HashMap h = new HashMap();
        h.put("2","2");
    };
    
    public static void main(String[] args) throws InterruptedException {
    
        TestLock tl = new TestLock();
        
        for ( int i = 0 ; i < 10 ; i++){
            
            new Thread( () -> {
                for( int j = 0 ; j < 10000 ; j++){
                    tl.inc();;
                }
            }).start();
        }
    
        Thread.sleep(1000);
        System.out.println("a的值是"+tl.a);
    }
}
