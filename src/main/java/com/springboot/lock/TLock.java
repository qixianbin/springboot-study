package com.springboot.lock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class TLock implements Lock {
    
    AtomicReference<Thread> owner = new AtomicReference<>();
    BlockingQueue<Thread> waiter = new LinkedBlockingDeque();
    
    @Override
    public void lock() {
        while ( !owner.compareAndSet(null,Thread.currentThread()) ){
            waiter.add(Thread.currentThread());
            LockSupport.park();//当前线程阻塞
            waiter.remove(Thread.currentThread());
        }
        
    }
    
    @Override
    public void unlock() {
        if ( owner.compareAndSet(Thread.currentThread(),null) ){
            for (Object w :waiter.toArray() ) {
                Thread t = (Thread)w;
                LockSupport.unpark(t);
            }
        }
    }
    
    @Override
    public void lockInterruptibly() throws InterruptedException {
    
    }
    
    @Override
    public boolean tryLock() {
        return false;
    }
    
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
    
    @Override
    public Condition newCondition() {
        return null;
    }
}
