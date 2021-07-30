package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * @Date: 2021/7/30
 * @Modify By:
 */
public class C_LastStoneWeightII {
    public static void main(String[] args) {
        C_LastStoneWeightII test = new C_LastStoneWeightII();
        System.out.println(test.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

    /**
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        // 状态定义：dp[i][j] 表示从下表为0 - i的石子放进容量为j的背包中能带来真的最大价值
        // 状态转移： 当前石子要和前面的碰撞：dp[i][j] = dp[i-1][abs(j)]
        // 状态初始化：dp[0][0] = 0; dp[0][j] = 0; dp[i][0] = 0 ; ==> dp[i][j] = 0
        int len = stones.length;
        if (len == 1) {
            return stones[0];
        }
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int maxTarget = sum >> 1;
        int[][] dp = new int[len][maxTarget + 1];
        for (int i = maxTarget; i >= stones[0]; i--) {
            dp[0][i] = dp[0][i - stones[0]] + stones[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= maxTarget; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }

        return Math.abs((sum - dp[len - 1][maxTarget]) - dp[len - 1][maxTarget]);

    }
}
