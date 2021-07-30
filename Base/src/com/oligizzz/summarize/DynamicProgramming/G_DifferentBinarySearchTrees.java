package com.oligizzz.summarize.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @Date: 2021/7/28
 * @Modify By:
 */
public class G_DifferentBinarySearchTrees {

    public static void main(String[] args) {
        G_DifferentBinarySearchTrees test = new G_DifferentBinarySearchTrees();
        System.out.println(test.numTrees(4));
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    dp[i] += 2 * dp[j - 1];
                } else {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
        }
        return dp[n];
    }

    /**
     * 改进
     *
     * @param n
     * @return
     */
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
