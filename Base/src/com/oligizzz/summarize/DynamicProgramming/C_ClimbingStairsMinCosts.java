package com.oligizzz.summarize.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * @Date: 2021/7/27
 * @Modify By:
 */
public class C_ClimbingStairsMinCosts {
    public static void main(String[] args) {
        C_ClimbingStairsMinCosts test = new C_ClimbingStairsMinCosts();
        System.out.println(test.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        // 1、为啥可以用动态规划 ：到第一层只能跨一层花费cost[1]+cost[0] , 或者直接到达,花费cost[1];
        // 第二层可由第一层到达，花费dp[1]+cost[2],或者由第0层到达，花费dp[0]+cost[2];
        // 所以 第i层可以有i-1层和i-2层支付当前层（第i层）费用后达到，我们取最小的就行
        // 2、状态定义: dp[i] 表示到达第 i 层的最小花费
        // 3、状态转移：dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i]
        // 4、状态初始化：dp[0] = 0, dp[1] = cost[0]
        // 5、到达目标层后
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);

    }
}
