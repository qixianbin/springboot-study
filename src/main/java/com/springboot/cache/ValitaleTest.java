package com.springboot.cache;

import java.util.Date;

public class ValitaleTest {
    static int a = 0;
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
    
        Date d1 = new Date();
        new Thread(()->{
            while ( a == 0 ){
                System.out.println("123123");
            }
        }).start();
    
        //Thread.sleep(1000);
        a = 1;
        System.out.println("时间差"+(new Date().getTime() - d1.getTime()));
    
        System.out.println(Thread.currentThread().getName()+"=="+threadLocal.get());
        threadLocal.set(222);
        System.out.println(Thread.currentThread().getName()+"=="+threadLocal.get());
        
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"=="+threadLocal.get());
            threadLocal.set(123);
            System.out.println(Thread.currentThread().getName()+"=="+threadLocal.get());
        }).start();
    
        System.out.println(Thread.currentThread().getName()+"=="+threadLocal.get());
    }
}
