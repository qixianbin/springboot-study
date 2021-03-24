package com.springboot.airthmetic.searchAirthmetic;

/**
 * 插值查找算法：本质跟二分查找一样
 * 区别：不是直接拿中间坐标进行切分，根据要查找的值进行自适应的获取mid坐标
 * 插值算法并不一定能百分百的快于二分查找：
 *      在数据量比较大，关键字分布比较均匀的情况下，优于二分查找；在分布不均匀的情况下不一定优于二分查找
 */
public class InsertSearch {
    
    static int[] a = {1,2,3,4,5,6,7,8};
    static int count = 0;
    
    public static void main(String[] args) {
        int index = insertSearch(a,0,a.length - 1,1000000000);
        System.out.println("index = " + index+"，递归次数：" + count +"次");
    }
    
    public static int insertSearch(int[] a, int left, int right, int findVal){
        count++;
        if(left > right || findVal < a[0] || findVal > a[a.length - 1]) {//递归完成都没有找到
            return -1;
        }
    
        int mid = left + ( right - left ) * ( findVal - a[left] ) / ( a[right] - a[left] );
    
        if(findVal > a[mid]){//要查找的值大于中间值
            return insertSearch(a,mid + 1,right, findVal);//向右递归
        }else if(findVal < a[mid]){//要查找的值小于中间值
            return insertSearch(a, left, mid - 1, findVal);//向左递归
        }else{//要查找的值等于中间值
            return mid;
        }
    };

}
