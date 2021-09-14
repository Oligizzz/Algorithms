package com.oligizzz.algorithms.DynamicProgramming;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/15
 * @Modify By:
 */
public class LeetCode576 {
    public static void main(String[] args) {
        LeetCode576 test = new LeetCode576();
        System.out.println(test.findPaths(2, 2, 2, 0, 0));
    }

    private int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] temp = new int[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                for (int i2 = 0; i2 < maxMove + 1; i2++) {
                    temp[i][i1][i2] = -1;
                }
            }
        }
        return dfs(m, n, maxMove, startRow, startColumn, temp);
    }

    /**
     * @param m
     * @param n
     * @param canMove
     * @param curR
     * @param curC
     * @return
     */
    private int dfs(int m, int n, int canMove, int curR, int curC, int[][][] temp) {
        if (curR < 0 || curR >= m || curC < 0 || curC >= n) {
            return 1;
        }

        if (canMove == 0) {
            return 0;
        }

        if (curR - canMove >= 0 && curC - canMove >= 0 && curR + canMove < m && curC + canMove < n) {
            return 0;
        }
        if (temp[curR][curC][canMove] != -1) {
            return temp[curR][curC][canMove];
        }

        int sum = 0;
        for (int[] d : direction) {
            sum = (sum + dfs(m, n, canMove - 1, curR + d[0], curC + d[1], temp)) % 1000000007;
        }
        temp[curR][curC][canMove] = sum;
        return sum;
    }
}
