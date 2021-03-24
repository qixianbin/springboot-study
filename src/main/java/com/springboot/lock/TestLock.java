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
    
        Thread.sleep(1000);//让主线程休眠，否则上面的子线程无法执行完成会造成后面的sout数据不准确
        System.out.println("a的值是"+tl.a);
    }
}
