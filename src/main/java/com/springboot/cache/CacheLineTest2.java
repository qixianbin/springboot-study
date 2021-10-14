package com.springboot.cache;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 此代码可证明两个问题
 *      1、加了volatile以后，多线程修改需要重新从内存中读取数据，速度会变慢
 *      2、64字节的缓存行，加上7个long以后，效率会提高，此测试必须加volatile     空间换时间
 */
public class CacheLineTest2 {

    static long count = 1_0000_0000l;
    static class T{
//        private long l1,l2,l3,l4,l5,l6,l7;
        private volatile  long l = 0l;
    }

    static T[] a = new T[2];
    
    static{
        a[0] = new T();
        a[1] = new T();
    }
    
    public static void main(String[] args) throws InterruptedException {
    
        CountDownLatch countDownLatch = new CountDownLatch(2);
    
        Thread thread1 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                a[0].l = i;
            }
            countDownLatch.countDown();
        });
    
        Thread thread2 = new Thread(() -> {
            for (long i = 0; i < count; i++) {
                a[0].l = i;
            }
            countDownLatch.countDown();
        });
    
        Date start = new Date();
        
        thread1.start();
        thread2.start();
        countDownLatch.await();
    
        System.out.println(new Date().getTime() - start.getTime());
        
    }
}
