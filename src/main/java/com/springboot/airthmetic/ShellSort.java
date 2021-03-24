package com.springboot.airthmetic;

import java.util.Arrays;
import java.util.Date;

public class ShellSort {
    
    public static void main(String[] args) {
        int a[] = {10,8,5,7,3,4,2};
        shellSortSwap(a);
        System.out.println("交换法结果："+Arrays.toString(a));
        a = new int[]{10, 8, 5, 7, 3, 4, 2};
        shellSortMove(a);
        System.out.println("移动法结果："+Arrays.toString(a));
    
        System.out.println("====================性能测试====================");
    
        int b[] = new int[100000];
        for (int i= 0; i < 100000; i++){
            b[i] = (int)(Math.random()*100000);
        }
        Date start = new Date();
        shellSortSwap(b);
        System.out.println("十万数据量的希尔排序（交换法）耗时："+((new Date().getTime()-start.getTime()))+"豪秒");
        
        for (int i = 0 ; i < 100000 ; i++){
            b[i] = (int)(Math.random()*100000);
        }
        Date start2 = new Date();
        shellSortMove(b);
        System.out.println("十万数据量的希尔排序（移动法）耗时："+((new Date().getTime()-start2.getTime()))+"豪秒");
    }
    
    public static void shellSortSwap(int a[]){
        for (int gap = a.length / 2; gap > 0; gap /= 2 ){
            for(int i = gap; i < a.length; i++){
                for(int j = i - gap; j >=0; j -= gap){
                    if (a[j] > a[j + gap]){
                        int tmp = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = tmp;
                    }
                }
            }
        }
    }
    
    public static void shellSortMove(int a[]){
        int shellIndex = 0;
        int shellVal = 0;
        for (int gap = a.length / 2; gap > 0; gap /= 2 ){
            for(int i = gap; i < a.length; i++){
                shellIndex = i;
                shellVal = a[shellIndex];
                if(shellVal < a[shellIndex - gap]){
                    while (shellIndex - gap >= 0 && shellVal < a[shellIndex - gap]){
                        a[shellIndex] = a[shellIndex - gap];
                        shellIndex -= gap;
                    }
                    a[shellIndex] = shellVal;
                }
            }
        }
    }
}
