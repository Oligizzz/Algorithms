package com.oligizzz.summarize.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * https://leetcode-cn.com/problems/integer-break/
 * @Date: 2021/7/28
 * @Modify By:
 */
public class F_SplitInteger {
    public static void main(String[] args) {
        F_SplitInteger test = new F_SplitInteger();
        System.out.println(test.integerBreak(8));
    }

    public int integerBreak(int n) {
        // 1、为啥可以用动态规划：任意一个大于2的整数N拆分后的乘积最大值都可以由前面的[0,N-1]的最大积乘上差值的最大积得到
        // 2、状态定义： dp[i] 表示正整数 i 拆分后得到的乘积最大值
        // 3、状态转移方程： dp[i] = Math.max(max, Math.max(dp[i - j] * j, j * (i - j)));
        // 4、状态初始化：dp[0] = 0; dp[1] = 0; dp[2] = 1;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                max = Math.max(max, Math.max(dp[i - j] * j, j * (i - j)));
            }
            dp[i] = max;
        }

        return dp[n];
    }
}
