package com.oligizzz.summarize.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @Date: 2021/7/28
 * @Modify By:
 */
public class E_UniquePathsHandicapped {
    public static void main(String[] args) {
        E_UniquePathsHandicapped test = new E_UniquePathsHandicapped();
        System.out.println(test.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 1、为啥可以用动态规划：以为到达[i,j]都可以由[i,j-1]或者[i-1,j]移动一步到达，所以状态可有这两个地方转移而来
        // 2、状态定义：dp[i,j]表示由[0,0]位置到达[i,j]位置的方案数量
        // 3、状态转移：dp[i,j] = dp[i-1,j]+dp[i,j-1];
        // 4、状态初始化：dp[0][0] = 1;dp[i,0] = 1;dp[0,j] = 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                if (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1) {
                    dp[i][j] = 0;
                }
                if (obstacleGrid[i][j - 1] == 0 && obstacleGrid[i - 1][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        // 1、为啥可以用动态规划：以为到达[i,j]都可以由[i,j-1]或者[i-1,j]移动一步到达，所以状态可有这两个地方转移而来
        // 2、状态定义：dp[i,j]表示由[0,0]位置到达[i,j]位置的方案数量
        // 3、状态转移：dp[i,j] = dp[i-1,j]+dp[i,j-1];
        // 4、状态初始化：dp[0][0] = 1;dp[i,0] = 1;dp[0,j] = 1;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 其实有障碍物的路径是不用统计的
                if (obstacleGrid[i][j] == 1) {
                    continue;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }

            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[m - 1][n - 1];
    }
}
