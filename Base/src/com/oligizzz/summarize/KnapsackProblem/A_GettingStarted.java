package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 背包问题入门：
 * 有N件物品和一个最多能被重量为W 的背包。
 * 第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 * @Date: 2021/7/28
 * @Modify By:
 */
public class A_GettingStarted {

    public static void main(String[] args) {
        A_GettingStarted test = new A_GettingStarted();
        System.out.println(test.template(new int[]{1, 3, 4}, new int[]{15, 20, 30}, 4));
    }

    /**
     * 简单的背包问题
     *
     * @param weight 每个物品的重量
     * @param values 每个物品的价值
     * @param maxCap 背包的最大容量
     * @return
     */
    public int template(int[] weight, int[] values, int maxCap) {
        int n = weight.length;
        // 状态定义： dp[i][j] 表示从下标为 0 - i  的所有物品中随便选择放与不放入容量为 j 的背包中能带来的最大价值
        // 状态转移 ： 不放入第i件物品：dp[i][j] = dp[i-1][j]; 放入第 i 件物品：dp[i-1][j -weight[i]] + values[i]
        // 状态初始化： dp[i][0] = 0; dp[0][j] = dp[0][j-weight[i]] + values[i]
        int[][] dp = new int[n][maxCap + 1];
        for (int i = maxCap; i >= weight[0]; i--) {
            dp[0][i] = dp[0][i - weight[0]] + values[0];
        }
        // 先遍历容量，在遍历物品
        for (int j = 0; j <= maxCap; j++) {
            for (int i = 1; i < n; i++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + values[i]);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][maxCap];

    }
}
