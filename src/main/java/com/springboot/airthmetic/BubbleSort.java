package com.springboot.airthmetic;

import java.util.Arrays;
import java.util.Date;

/**
 * 冒泡排序：
 *  循环比较两个相邻的数据，如果前一个数据比后一个数据大，就交换两个数
 *  第一次循环以后，最大数放到了最后的位置，故第二次循环时就不需要在进行最后两个数的比较，同理第三次循环时不需要进行最后三个数的比较，故内层循环采用 length -1 -i
 *  添加一个flag标记，记录本次循环是否进行过数据交换，如果没有进行过数据交换，说明此时就是按照顺讯排放的数组，不需要再进行循环比较
 *
 */
public class BubbleSort {
    
    public static void main(String[] args) {
    
        int a[] = {10,9,8,7,5,4,3,2,1,0};//需要排序的数组
        bubbleSort(a);
        print(a);
    
        System.out.println("================性能测试===============");
    
        int b[] = new int[100000];
        for (int i= 0; i < 100000; i++){
            b[i] = (int)(Math.random()*100000);
        }
        Date start = new Date();
        bubbleSort(b);
        System.out.println("十万数据量的冒泡排序耗时："+((new Date().getTime()-start.getTime()))+"豪秒");
    }
    
    public static void bubbleSort(int a[]){
        boolean flag = false;//数据交换的标记位
        //外层循环，表示需要进行length - 1次比较
        for (int i = 0 ; i < a.length - 1 ; i++){
            flag = false;//每次循环时初始化标记位
            //循环判断
            for (int j = 0 ; j < a.length - 1 - i ; j++){
                //比较两个相邻的元素，如果前一个数据比后一个大，就交换顺序并修改交换标记
                if(a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = true;
                }
            }
        
            //判断本次循环如果未进行数据交换，则表明当前已经按顺序排序，可停止比较
            if(!flag)
                break;
        }
    }
    
    public static void print(int a[]){
        System.out.println("排序后的结果："+Arrays.toString(a));
    }
    
}
