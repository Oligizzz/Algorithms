package com.oligizzz.algorithms.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description:
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * @Date: 2021/7/17
 * @Modify By:
 */
public class Offer42 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        // 状态定义：dp[i] 表示以第i个数字结尾的连续子数组的最大值
        int [] dp = new int[len+1];
        // 状态初始化
        dp[0] = 0;
        int res = dp[0];
        for(int i = 1 ; i < len ; i++){
            //状态转移,
            dp[i+1] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(res,dp[i+1]);
        }
        return res;
    }
}
