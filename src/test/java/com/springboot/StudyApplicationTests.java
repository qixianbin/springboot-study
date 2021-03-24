package com.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudyApplicationTests {

    @Test
    void contextLoads() {
        byte a = 1;
        byte b = 2;
        byte c = (byte)130;
//        byte g = a + b;
        
        int d = 1000;
        int e = 1000;
        int f;
//        System.out.println("f:"+f);
        System.out.println(d == e);
        System.out.println("a:"+a+"b:"+b+"c:"+c);
        
        float f1 = 0.1f;
        float f2 = 123;
        float fc = f1 + f2;
        
        Integer i1 = 12300;
        Integer i2 = 12300;
        System.out.println(i1 == i2);
        
    }

}
