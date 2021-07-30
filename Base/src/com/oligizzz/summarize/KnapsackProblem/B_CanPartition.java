package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @Date: 2021/7/28
 * @Modify By:
 */
public class B_CanPartition {
    public static void main(String[] args) {
        B_CanPartition test = new B_CanPartition();
        System.out.println(test.canPartition(new int[]{2, 2, 1, 1}));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }

        // 奇数不合题意
        if ((sum & 1) == 1) {
            return false;
        }
        // 1、状态定义： dp[i][j] 表示能否从下表为 0-i 的元素中随便选择若干元素后sum达到 j；
        // 2、状态转移： dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]]
        // 3、状态初始化：dp[0][0] = false;
        int targetValue = sum / 2;
        boolean[][] dp = new boolean[len][targetValue + 1];
        if (nums[0] <= targetValue) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= targetValue; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == targetValue) {
                    dp[i][j] = true;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][targetValue];

    }

}
