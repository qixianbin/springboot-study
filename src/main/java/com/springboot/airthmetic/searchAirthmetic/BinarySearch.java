package com.springboot.airthmetic.searchAirthmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分法查找：
 *  思路：
 *      1、确定数组的中间下标（mid = (left + right) / 2）
 *      2、让需要查找的数[findVal]和中间下标的值[a[mid]]比较
 *          2.1、findVal > a[mid]，说明要查找的数在mid右边，因此需要向右递归查找
 *          2.2、findVal < a[mid]，说明要查找的数在mid左边，因此需要向左递归查找
 *          2.1、findVal = a[mid]，说明要查找的数已经找到，直接返回
 *      3、结束递归：
 *          3.1、找到时需要结束
 *          3.2、递归完整个数组，当left > right时需要结束
 */
public class BinarySearch {
    
    static int[] a = {1,2,3,4,5,5,5,6,7,8};
    static int count = 0;
    public static void main(String[] args) {
    
//        int index = binarySearch(a,0,a.length - 1,5);
//        System.out.println("index = " + index+"，递归次数：" + count +"次");
    
        List list = binarySearch2(a,0,a.length - 1,8);
        System.out.println("index = " + list+"，递归次数：" + count +"次");
    };

    //普通二分查找，查找到要查找的值就结束
    public static int binarySearch(int[] a,int left,int right,int findVal){
        count++;
        if(left > right || findVal < a[0] || findVal > a[a.length - 1]) {//递归完成都没有找到
            return -1;
        }
        
        int mid = (left + right) / 2;
        
        if(findVal > a[mid]){//要查找的值大于中间值
            return binarySearch(a,mid + 1,right, findVal);//向右递归
        }else if(findVal < a[mid]){//要查找的值小于中间值
            return binarySearch(a, left, mid - 1, findVal);//向左递归
        }else{//要查找的值等于中间值
            return mid;
        }
    };
    
    //扩展二分查找，查找所有满足条件的值
    public static List<Integer> binarySearch2(int[] a,int left,int right,int findVal){
        count++;
        if(left > right) {//递归完成都没有找到
            return new ArrayList<>();
        }
        
        int mid = (left + right) / 2;
        
        if(findVal > a[mid]){//要查找的值大于中间值
            return binarySearch2(a,mid + 1,right, findVal);//向右递归
        }else if(findVal < a[mid]){//要查找的值小于中间值
            return binarySearch2(a, left, mid - 1, findVal);//向左递归
        }else{//要查找的值等于中间值
            /**
             * 查找到以后不立刻返回
             * 1、向mid左扫描，将满足条件的下标，存入到集合中
             * 2、向mid右扫描，将满足条件的下标，存入到集合中
             * 3、返回集合
             */
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true){
                if(temp < 0 || a[temp] != findVal)
                    break;
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (true){
                if(temp > a.length - 1 || a[temp] != findVal)
                    break;
                list.add(temp);
                temp++;
            }
            return list;
        }
    };
}
