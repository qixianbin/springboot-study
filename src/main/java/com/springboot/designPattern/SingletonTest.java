package com.springboot.designPattern;

/**
 * 懒汉式
 */
public class SingletonTest {
    
    //必须加volatile，避免指令重排序，导致生成单例的时候出现指令重排序
    private volatile static SingletonTest singletonTest = null;
    
    private SingletonTest(){};
    
    public static SingletonTest getInstance(){
      if(singletonTest == null){//避免锁竞争
          synchronized (singletonTest){//加锁
              if(singletonTest == null){
                  singletonTest = new SingletonTest();
              }
          }
      }
      return singletonTest;
    };
}
