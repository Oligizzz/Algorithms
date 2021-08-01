package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * @Date: 2021/7/31
 * @Modify By:
 */
public class E_OnesAndZeros {
    public static void main(String[] args) {
        E_OnesAndZeros test = new E_OnesAndZeros();
        System.out.println(test.findMaxForm2(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        // 1、状态定义：dp[i][j][z]表示从下标为0-i的元素中随意搭配能装满容量为j和z的子集长度
        // 2、状态转移：dp[i][j][z] = Math.max(dp[i-1][j][z],dp[i-1][j-map[i][0]][z- map[i][1]])
        int len = strs.length;
        int[][] map = new int[len + 1][2];
        for (int i = 0; i < len; i++) {
            String a = strs[i];
            for (char c : a.toCharArray()) {
                map[i][c - '0']++;
            }

        }

        int[][][] dp = new int[len][m + 1][n + 1];

        for (int j = m; j >= map[0][0]; j--) {
            for (int z = n; z >= map[0][1]; z--) {
                dp[0][j][z] = dp[0][j - map[0][0]][map[0][1]] + 1;
            }
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                for (int z = 0; z <= n; z++) {
                    dp[i][j][z] = dp[i - 1][j][z];
                    if (map[i][0] <= j && map[i][1] <= z) {
                        dp[i][j][z] = Math.max(dp[i - 1][j][z], dp[i - 1][j - map[i][0]][z - map[i][1]] + 1);
                    }
                }
            }
        }
        return dp[len - 1][m][n];
    }

    /**
     * 空间优化
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[j][k] 表示容量不超过 j 和 k 的子集长度
        // 状态转移： dp[j][k] = Math.max(dp[j][k] , dp[j - curZeros][ k - Ones]);
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < len; i++) {
            int[] count = count(strs[i]);
            int curZeros = count[0];
            int curOnes = count[1];
            for (int j = m; j >= curZeros; j--) {
                for (int k = n; k >= curOnes; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - curZeros][k - curOnes] + 1);
                }
            }
        }
        return dp[m][n];


    }

    /**
     * 统计0 和1
     *
     * @param str
     * @return
     */
    private int[] count(String str) {

        int[] res = new int[2];
        for (char c : str.toCharArray()) {
            res[c - '0']++;
        }
        return res;
    }


    static int a[][] = new int[4][601];

    /**
     * +10086大神
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm3(String[] strs, int m, int n) {
        int ss = strs.length, res = 0, x1 = n + 1, y1 = m + 1;
        for (int i = 0, x, y, z, j; i < ss; ++i) {
            String s = strs[i];
            for (z = y = s.length(), x = 0, j = 0; j < y; x += s.charAt(j++) & 1) {
                ;
            }
            y -= x;
            if (x < x1) {
                x1 = x;
            }
            if (y < y1) {
                y1 = y;
            }
            a[0][i] = (x << 7) + y;
            a[1][i] = (y << 7) + x;
            a[2][i] = (z << 16) + (x << 7) + y;
            a[3][i] = (z << 16) + (y << 7) + x;
            if (z == 1) {
                a[0][i] += y << 16;
                a[1][i] += x << 16;
                a[2][i] += y << 16;
                a[3][i] += x << 16;
            } else if (y == 0 || y == z) {
                a[0][i] += z << 16;
                a[1][i] += z << 16;
                a[2][i] += z << 16;
                a[3][i] += z << 16;
            }
        }
        if (x1 > n || y1 > m) {
            return 0;
        }
        Arrays.sort(a[0], 0, ss);
        Arrays.sort(a[1], 0, ss);
        Arrays.sort(a[2], 0, ss);
        Arrays.sort(a[3], 0, ss);
        x1 = m;
        y1 = n;
        for (int j = 4, i, x, y, z; 0 != j--; ) {
            for (i = 0, z = 0, n = x1, m = y1; i < ss; ++i) {
                x = (a[j][i] >> 7) & 127;
                y = a[j][i] & 127;
                if (x <= n && y <= m) {
                    m -= y;
                    n -= x;
                    ++z;
                }
            }
            i = x1;
            x1 = y1;
            y1 = i;
            if (z > res) {
                res = z;
            }
        }
        return res;
    }


}
