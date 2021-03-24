package com.springboot.airthmetic;

public class Queen8 {
    
    int max = 8;//行数
    int[] result = new int[max];//定义一维数组的下标代表行，值代表列
    static int resultCount = 0;//统计一共有多少答案
    static int checkCount = 0;//统计一共用多少步计算完成
    
    public static void main(String[] args) {
        Queen8 q = new Queen8();
        q.put(0);//从第一个位置开始防止皇后
        System.out.println("一共有多少答案:"+resultCount);
        System.out.println("一共用多少步计算完成:"+checkCount);
    }
    
    //放置皇后
    private void put(int n){//向第n行放置元素
        if ( n == max){//n如果等于最大值，则结束
            resultCount++;
            for (int i = 0; i < max; i++){//输出满足要求的数组
                System.out.print(result[i] + " ");
            };
            System.out.println();
            return;
        }
        
        //循环对该行的每一列进行放值
        for (int i = 0; i < max; i++){
            result[n] = i;//先把皇后从第一列开始放，一直放到最后一列
            if(check(n)){//检查该行放置的皇后是否满足要求
                put( n+1);//如果满足要求，继续放下一行的值
            };
            //如果不满足要求，不用操作，因为此时i会+1，继续往该行的下一列放值
        }
    }
    
    //检查是否满足要求（任意两个皇后不在同一直线和斜线）
    private boolean check(int n){
        checkCount++;//统计一共执行了多少次
        //校验是否在同一列：result[n] == result[i]
        //校验是否在同一斜线：Math.abs(n - i) ==Math.abs(result[n] - result[i])
        for (int i = 0; i < n; i++){
            if (result[n] == result[i] || Math.abs(n - i) ==Math.abs(result[n] - result[i])){
                return false;
            }
        }
        return true;
    }
    
}
