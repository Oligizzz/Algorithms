package com.oligizzz.summarize.KnapsackProblem;

/**
 * @Author: GNMD
 * @Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * https://leetcode-cn.com/problems/climbing-stairs/
 * @Date: 2021/7/31
 * @Modify By:
 */
public class H_ClimbingStairs {
    public static void main(String[] args) {
        H_ClimbingStairs test = new H_ClimbingStairs();
        System.out.println(test.climbStairs(2));
    }

    /**
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int [] dp = new int[n + 1];
        for(int i = 1 ; i <= 2 ; i++){
            for(int j = 1 ; j <= n ; j++){
                dp[j] = dp[j] + dp[j-i];
            }
        }
        return dp[n];
    }
}
