package com.springboot.airthmetic;

import java.util.Arrays;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectionSort {
    
    public static void main(String[] args) {
        
        int a[] = {5,4,3,2,1,-1};//要排序的数组
        selectionSort(a);
        print(a);
    
        System.out.println("====================性能测试====================");
        
        int b[] = new int[100000];
        for (int i= 0; i < 100000; i++){
            b[i] = (int)(Math.random()*100000);
        }
        Date start = new Date();
        selectionSort(b);
        System.out.println("十万数据量的选择排序耗时："+((new Date().getTime()-start.getTime()))+"豪秒");
    }
    
    public static void selectionSort(int a[]){
        int min = 0;
        int minIndex = 0;
        //外层循环，表示循环从第一个数到最后一个数遍历进行比较
        for (int i = 0; i < a.length -1 ; i++){
            min = a[i];
            minIndex = i;
            for ( int j = i + 1; j < a.length; j++){
                if(min > a[j]){
                    min = a[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                a[minIndex] = a[i];
                a[i] = min;
            }
        
            //System.out.println("第"+(i+1)+"次交换后的结果："+ Arrays.toString(a));
        }
    }
    
    public static void print(int a[]){
        System.out.println("排序后的结果："+Arrays.toString(a));
    }
}
