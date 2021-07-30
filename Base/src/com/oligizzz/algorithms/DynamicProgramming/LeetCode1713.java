package com.oligizzz.algorithms.DynamicProgramming;

import com.oligizzz.algorithms.ApplicationQuestions.LeetCode1743;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * <p>
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 * <p>
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * <p>
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 * @Date: 2021/7/26
 * @Modify By:
 */
public class LeetCode1713 {
    public static void main(String[] args) {
        System.out.println(LeetCode1713.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1}));
    }

    public static int minOperations(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        // 状态定义，dp[i][j]表示 target 下标 i - 1 结尾序列 和arr 以下标 j - 1 结尾序列最长子序列长度
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (target[i - 1] == arr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i-1][j]);
                }
            }
        }

        return m - dp[m][n];
    }
}
