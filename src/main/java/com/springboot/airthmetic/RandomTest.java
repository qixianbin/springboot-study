package com.springboot.airthmetic;

import java.util.Random;

public class RandomTest {
    
    public static void main(String[] args) {
      for (int i = 0; i < 1000; i++){
          String c1 = checkCode();
          String c2 = new Random().nextInt(9999)+"";
          String c3 = Math.random()*9000+1000+"";
    
          System.out.println(c1+"==="+c2+"==="+c3);
      }
    }
    
    public static String checkCode(){
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(new Random().nextInt(10));
            sRand += rand;
        }
        return sRand;
    }
}
