package com.oligizzz.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */
public class Test {

    public static void main(String []args){
        int a=2;
        int b=2;
        int aResult;
        int bResult;
        long startTime;
        long endTime;
        long time;

        //乘法运算
        startTime=System.currentTimeMillis();
        for(int i=0;i<250000000;i++){
            bResult=b*1024;
        }
        endTime=System.currentTimeMillis();
        time=endTime-startTime;
        System.out.println("乘法250000000次时间："+time);

        //位运算
        System.out.println(Integer.toBinaryString(1024));
        startTime=System.currentTimeMillis();
        for(int i=0;i<250000000;i++){
            aResult=a<<10;
        }
        endTime=System.currentTimeMillis();
        time=endTime-startTime;
        System.out.println("位移100000000次时间："+time);
    }

}
