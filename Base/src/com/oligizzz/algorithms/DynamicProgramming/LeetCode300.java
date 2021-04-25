package com.oligizzz.algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/25
 * @Modify By:
 */
public class LeetCode300 {

    public static void main(String[] args) {
        LeetCode300 leetCode300 = new LeetCode300();
        System.out.println(leetCode300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len<2){return len;}
        int [] dp = new int[len];
        Arrays.fill(dp,1);
        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j < i ; j ++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len-1];
    }
}
