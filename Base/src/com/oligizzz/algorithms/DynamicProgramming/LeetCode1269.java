package com.oligizzz.algorithms.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description:
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 *
 * 状态定义：
 *      dp[i][j]：表示当前剩余i步，并且下标在j位置处的方案总数
 * 状态初始化：
 *      dp[steps][0]=1
 *状态转移：
 *      dp[i][j] = dp[i+1][j]----不移动
 *              +
 *      dp[i][j] = dp[i+1][j-1] --- 向左移动
 *              +
 *      dp[i][j] = dp[i+1][j+1] --- 向右移动
 *边界控制：下表最远能到达位置：Math.min(arrLen - 1 ， steps/2 )；
 * @Date: 2021/5/13
 * @Modify By:
 */
public class LeetCode1269 {
    int m = (int)1e9+7;

    public static void main(String[] args) {
        LeetCode1269 leetCode1269 = new LeetCode1269();
        System.out.println(leetCode1269.numWays(3, 2));
    }
    public int numWays(int steps, int arrLen) {
        //下表最远能到达的位置
        int maxLen = Math.min(arrLen -1 , steps/2);
        int [][] dp = new int[steps+1][maxLen+1];
        dp[steps][0] = 1;
        for(int i = steps -1 ; i>=0 ; i--){
            for(int j = 0 ; j <= maxLen ;  j++){
                dp[i][j] = dp[i+1][j]%m;
                if(j-1>=0){
                    dp[i][j]+=dp[i+1][j-1]%m;
                }
                if(j+1<=maxLen){
                    dp[i][j]+=dp[i+1][j+1]%m;
                }
            }
        }
        return dp[0][0];
    }
}
