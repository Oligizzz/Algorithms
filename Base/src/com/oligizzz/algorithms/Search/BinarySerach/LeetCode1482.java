package com.oligizzz.algorithms.Search.BinarySerach;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1
 * bloomDay.length == n
 * 1 <= n <= 10^5
 * 1 <= bloomDay[i] <= 10^9
 * 1 <= m <= 10^6
 * 1 <= k <= n
 * @Date: 2021/5/9
 * @Modify By:
 */
public class LeetCode1482 {
    public static void main(String[] args) {
        LeetCode1482 leetCode1482 = new LeetCode1482();
        leetCode1482.minDays(new int[]{5,4,8,7,3,6,9,4,8,5,45},2,2);
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        if(len < m*k){ return -1;}

        int lo = 1;
        int hi = (int)1e9;
        while(lo < hi){
            int mid = lo + (hi - lo >>1);
            if(isLegal(bloomDay,mid,m , k)){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return hi;

    }


    private boolean isLegal(int [] bloomDay , int curDay , int m ,int k ){
        int sum = 0 ;
        int CanUsed = 0;
        for(int i = 0 ; i < bloomDay.length ; i ++){
            //今天花已经开了--可用
            if(bloomDay[i]<=curDay){
                CanUsed++;
                if(CanUsed == k){
                    sum++;
                    CanUsed = 0;
                }
            }else{
                CanUsed=0;
            }
        }

        return sum>=m;
    }
}
