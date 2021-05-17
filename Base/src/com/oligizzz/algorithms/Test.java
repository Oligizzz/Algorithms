package com.oligizzz.algorithms;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        int k = 100;
        int [] a = new int[k];
        int sum = 0;
        for(int i = 0 ; i < k ; i ++){
            a[i] = test.sum();
            sum+=a[i];
        }
        System.out.println(sum/k);
        System.out.println("安居客放假啊");

    }

    private int sum(){
        int s = 0 ;
        int count = 0;
        while(count< 4){
            int num=1+(int)(Math.random()*3);
            s+=1;
            if(num == 1){
                count+=1;
            }else {
                count = 0;
            }
        }
        return s;
    }




}
