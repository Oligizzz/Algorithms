package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * @Date: 2021/7/31
 * @Modify By:
 */
public class G_CombinationSumIV {

    public static void main(String[] args) {
        G_CombinationSumIV test = new G_CombinationSumIV();
        System.out.println(test.combinationSum4(new int[]{1,2,3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for(int i = 0 ; i < len ; i++){
                if(nums[i]<=j){
                    dp[j] = dp[j] + dp[j - nums[i]];
                }
            }

        }
        return dp[target];

//        int[] dp = new int[target + 1];
//        // 这个值被其它状态参考，设置为 1 是合理的
//        dp[0] = 1;
//
//        for (int i = 1; i <= target; i++) {
//            for (int num : nums) {
//                if (num <= i) {
//                    dp[i] += dp[i - num];
//                }
//            }
//        }
//        return dp[target];
    }
}
