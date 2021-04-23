package com.oligizzz.algorithms.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/16
 * @Modify By:
 */
public class LeetCode87 {
    public boolean isScramble(String s1, String s2) {
        char [] s = s1.toCharArray();
        char [] t = s2.toCharArray();
        if(s.length != t.length){ return false;}
        int len = s.length;
        //状态定义：
        //dp[i][j][k] 表示s串从i开始k长串可以由t串由j开始长度为k的串转换而来
        boolean [][][] dp = new boolean[len][len][len+1];

        //状态初始化
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j ++){
                dp[i][j][1] = s[i] == t[j];
            }
        }

        //状态转移
        //长度区间
        for(int w = 2 ; w <= len ; w ++){
            for(int i = 0 ; i <= len - w ; i ++){
                for(int j = 0 ; j <= len - w ; j ++){
                    // 可交换区间
                    for(int k = 1 ; k <= w-1 ; k ++){
                        //不交换
                        if(dp[i][j][k] && dp[i+k][j+k][w-k]){
                            dp[i][j][w] = true;
                            break;
                        }

                        // 交换
                        if(dp[i][j + w - k][k] && dp[i + k][j][w - k] ){
                            dp[i][j][w] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][len];
    }
}
