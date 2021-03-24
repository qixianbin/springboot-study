package com.springboot.DataStructures;

import com.springboot.lambda.InterfaceTest;
import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.lang.reflect.Field;
import java.text.DecimalFormat;

public class SparseArray {
    
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
    
        int n = Integer.valueOf(1)+1;
        String  no = new DecimalFormat("000").format(n);//3
        System.out.println(no);
        System.out.println("==============================");
        
        int allArr[][] = new int[11][11];
        allArr[2][3] = 6;
        for (int[] a: allArr) {
            for (int b: a) {
                System.out.printf("%d\t",b);
            }
            System.out.println();
        }
    
    
        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3
    
        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5
    
        int a = 2;
        int b = a + a;
    
        Integer c = 126;
        Integer d = 126;
    
        System.out.println(c==d);
        
        System.out.printf("%d + %d = %d", a, a, b); //
    }
}
