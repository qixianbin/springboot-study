package com.springboot.airthmetic;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class InsertionSort {
    
    public static void main(String[] args) {
        
        int a[] = {10,9,7,5,8,3};
        insertionSortSwap(a);
        System.out.println("交换法结果："+Arrays.toString(a));
        insertionSortMove(a);
        System.out.println("移动法结果："+Arrays.toString(a));
        
        
        System.out.println("====================性能测试====================");
    
        int b[] = new int[100000];
        for (int i = 0 ; i < 100000 ; i++){
            b[i] = (int)(Math.random()*100000);
        }
        Date start1 = new Date();
//        insertionSortSwap(b);
//        System.out.println("十万数据量的插入排序（交换法）耗时："+((new Date().getTime()-start1.getTime()))+"豪秒");
//
//        for (int i = 0 ; i < 100000 ; i++){
//            b[i] = (int)(Math.random()*100000);
//        }
//        Date start2 = new Date();
//        insertionSortMove(b);
//        System.out.println("十万数据量的插入排序（移动法）耗时："+((new Date().getTime()-start2.getTime()))+"豪秒");
    }
    
    /**
     * 交换法
     * @param a
     */
    public static void insertionSortSwap(int a[]){
        if(a == null || a.length < 1)
            return;
        for (int i = 1; i < a.length; i++){
        print(a);
            for(int j = i - 1; j >= 0 && a[j] > a[j + 1]; j--){
                swap(a,j,j+1);
            }
        }
    }
    
    /**
     * 移动法
     * @param a
     */
    public static void insertionSortMove(int a[]){
        if(a == null || a.length < 1)
            return;
        for (int i = 1; i < a.length; i++){
            //移动法1
/*            int insertVal = a[i];
            int insertIndex = i - 1;
            for(int j = insertIndex; j >= 0 && a[j] > insertVal; j--){
                a[j + 1] = a[j];
                insertIndex--;
            }
            a[insertIndex + 1] = insertVal;*/
            
            //移动法2
            int insertVal = a[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insertVal < a[insertIndex]){
                a[insertIndex + 1] = a[insertIndex];
                insertIndex--;
            }
            a[insertIndex + 1] = insertVal;
        }
    }
    
    /**
     * 交换法
     * @param a
     * @param i
     * @param j
     */
    public static void  swap(int a[],int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public static void print(int a[]){
        System.out.println("排序后的结果："+Arrays.toString(a));
    }
}
