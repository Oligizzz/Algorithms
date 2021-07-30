package com.oligizzz.summarize.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description:
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @Date: 2021/7/28
 * @Modify By:
 */
public class D_UniquePaths {
    public static void main(String[] args) {
        D_UniquePaths test = new D_UniquePaths();
        System.out.println(test.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        // 1、为啥可以用动态规划：以为到达[i,j]都可以由[i,j-1]或者[i-1,j]移动一步到达，所以状态可有这两个地方转移而来
        // 2、状态定义：dp[i,j]表示由[0,0]位置到达[i,j]位置的方案数量
        // 3、状态转移：dp[i,j] = dp[i-1,j]+dp[i,j-1];
        // 4、状态初始化：dp[0][0] = 1;dp[i,0] = 1;dp[0,j] = 1;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
