package com.springboot.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

public class LambdaTest {

    public static void main(String[] args) {

//        InterfaceTest test1 = (a,b) -> {return a+b;};
//        int incre = test1.incre(4, 5);
//        System.out.println(incre);
//
//        InterfaceTest test2 = (a,b) -> decre(a,b);
//        System.out.println(test2.incre(4,5));
//
//
//        Thread t = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println(2 + ":" + i);
//            }
//        });
//        t.start();
        ArrayList<Integer> list = new ArrayList<>();
    
        Collections.addAll(list, 1,2,3,4,5);
    
        //lambda表达式 方法引用
        list.forEach(System.out::println);
    
        list.removeIf(e -> e==5);
        
        list.forEach(e -> System.out.println(e));
        
        list.stream().forEach(e -> System.out.println(e));
    
        int num = 10;
    
        Consumer<String> consumer = ele -> {
            System.out.println(num);
        };
    
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(num);
            }
        };
    
        //num = num + 2;
        consumer.accept("hello");
    
        Class<? extends Consumer> aClass = consumer1.getClass();
        aClass.getDeclaredFields();
//        Class.forName();
    
    }
    
    public static int decre(int a,int b){
        return a-b;
    }
}
