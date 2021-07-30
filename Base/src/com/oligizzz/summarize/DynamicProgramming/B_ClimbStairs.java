package com.oligizzz.summarize.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description: 动态规划：爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * @Date: 2021/7/27
 * @Modify By:
 */
public class B_ClimbStairs {
    public static void main(String[] args) {
        B_ClimbStairs test = new B_ClimbStairs();
        System.out.println(test.climbStairs(3));
    }

    public int climbStairs(int n) {
        // 1、为啥可以用动态规划：第一层有 1 种方案，第二层有 2 种方案，
        // 要到达第三层 可以由第一层跨两布，也可以由第二层跨一步，所以第三层可以有第一层和第二层的状态推导出来
        // 2、状态定义：dp[i] 表示到达第 i 层可以有 dp[i]种方案
        // 3、状态转移方程： dp[i] = dp[i-1] + dp[i-2];
        // 4、状态初始化： dp[0] = 0, dp[1] = 1 ; dp[2] = 2;
        if (n <= 2) {
            return n;
        }

        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    /**
     * 空间优化
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int res = 0;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;

    }
}
