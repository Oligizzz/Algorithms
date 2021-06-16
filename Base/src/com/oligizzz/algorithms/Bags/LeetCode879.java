package com.oligizzz.algorithms.Bags;

/**
 * @Author: GNMD
 * @Description:
 * 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。
 *
 * 1、状态定义：
 *      dp [i][j][k] 表示前 i 项工作中一共选择了 j 位员工，并且利润为 k 的方案总数
 *
 * 2、状态转移：
 *      不能完成当前工作：
 *          dp[i][j][k] = dp[i-1][j][k];
 *      能够完成当前工作：
 *          dp[i][j][k] = dp [i-1][j][k] + dp[i-1][j-group[i]][Math.max(0,k-profit[i])];
 *
 * @Date: 2021/6/9
 * @Modify By:
 */
public class LeetCode879 {

    /**
     * 背包问题
     * @param n 员工人数
     * @param minProfit 最小盈利计划
     * @param group 第 i 项工作需要的人数
     * @param profit 第 i 项工作带来的价值
     * @return
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length,MOD = (int)1e9+7;
        int [][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for(int i = 1 ; i <= len ; i ++){
            //当前工作需要的人数
            int people = group[i-1];
            // 当前工作能带来的价值
            int pro = profit[i-1];
            for(int j = 0 ; j <= n ; j ++){
                for(int k = 0 ; k <= minProfit ; k ++){
                    //不能完成当前工作
                    if(j < people){
                        dp[i][j][k] = dp[i-1][j][k];
                    }else{
                        dp[i][j][k] = (dp [i-1][j][k] + dp[i-1][j-people][Math.max(0,k-pro)])%MOD;
                    }
                }
            }
        }

        int res = 0;
        for(int i = 0 ; i <= n ; i ++){
            res = (res+dp[len][i][minProfit])%MOD;
        }
        return res;
    }
}
