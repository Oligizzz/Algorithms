package com.oligizzz.summarize.KnapsackProblem;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * https://leetcode-cn.com/problems/target-sum/
 * @Date: 2021/7/30
 * @Modify By:
 */
public class D_TrgetSum {
    public static void main(String[] args) {
        D_TrgetSum test = new D_TrgetSum();
        System.out.println(test.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        // 状态定义： dp[i][j] 表示从0-i的数中组合为j的种类数量
        // 状态转移： dp[i][j] = ;
        int sum = 0;
        int len = nums.length;
        for (int a : nums) {
            sum += a;
        }
        if ((sum + target) % 2!= 0) {
            return 0;
        }

        int maxCap = (sum + target) / 2;
        int[][] dp = new int[len][maxCap + 1];
        for(int i = 0 ; i < len ; i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j <= maxCap ; j++){
            if(nums[0]>=j){
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= maxCap; j++) {
                if(j >= nums[i]){
                    dp[i][j] = dp[i-1][j] + dp[i - 1][ j - nums[i]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        for(int i = 0 ; i< len ; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[len - 1][maxCap];

    }
}
