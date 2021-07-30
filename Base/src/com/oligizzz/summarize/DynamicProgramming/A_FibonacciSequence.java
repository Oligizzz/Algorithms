package com.oligizzz.summarize.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description: 动态规划入门：斐波那契数列
 * @Date: 2021/7/27
 * @Modify By:
 */
public class A_FibonacciSequence {
    public static void main(String[] args) {
        A_FibonacciSequence fib = new A_FibonacciSequence();
        System.out.println(fib.fib3(10));
    }

    /**
     * 基础版
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        // 状态定义 dp[i]表示第i为斐波那契数列
        // 状态转移方程 dp[i] = dp[i-1] + dp[i-2];
        // 状态初始化 dp[0] = 0, dp[1] = 1
        // 遍历顺序： 从前往后，dp[i] 强依赖 dp[i-1] 和 dp[i-2]
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 基础班中可以发现每次其实只需要用到两个变量，维护这两个变量就行
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    /**
     * 递归版本
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n <= 1) {
            return n;
        }
        return fib3(n - 1) + fib3(n - 2);
    }


}
