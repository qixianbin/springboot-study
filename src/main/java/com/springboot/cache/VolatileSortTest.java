package com.springboot.cache;

import java.util.Date;

/**
 * 验证cpu乱序执行
 * 反证法；假如没有乱序问题，则x和y不可能同时为0
 *      thread1先完整执行：x=0，y=1
 *      thread2先完整执行：x=1，y=0
 *      thread1先执行第一条命令，thread2完整执行：x=1，y=1；
 *      thread2先执行第一条命令，thread1完整执行：x=1，y=1；
 *      thread1先执行第一条命令，thread2执行第一条命令；x=1，y=1
 *      thread2先执行第一条命令，thread1执行第一条命令；x=1，y=1
 *
 */
public class VolatileSortTest {
    /*volatile*/ static int a = 0,b = 0 ,x = 0,y = 0;
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        Date d = new Date();
        for (;;){
            a = 0;b = 0 ;x = 0;y = 0;
            i++;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });
    
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
    
            if(x == 0 && y == 0){
                System.out.println(a+""+b+""+x+""+y);
                System.out.println(i);
                System.out.println("耗时" + (new Date().getTime() - d.getTime()) + "ms");
                return;
            }
        }
    }
}
