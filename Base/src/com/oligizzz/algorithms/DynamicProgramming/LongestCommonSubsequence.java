package com.oligizzz.algorithms.DynamicProgramming;


/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */

/**
 * ①：状态定义：
 *    dp[i , j] 表示 str1[0 ~ i] 和 str2[0 ~ j] 之间的最长公共子序列长度
 *    str1[0~j]表示str1串从 0 到 j （包含j）
 * ②：状态转移：
 *     如果两个串的最后一个字符相等:
 *         dp[ i , j ] = dp [i-1 , j -1 ] + 1;
 *     如果不相等：
 *         dp[ i - j ] = Math.max( dp[i - 1 , j ] , dp [i , j -1] )
 *  ③: 状态初始化：
 *      如果 i 或者 j 等于 0 表示当前空串与另外一个穿得最长公共子序列长度为0
 *      dp [0 , j] = 0;
 *      dp [i , 0] = 0;
 *
 *  ④：遍历方向和范围：
 *      由于 dp[i][j] 依赖与 dp[i - 1][j - 1] , dp[i - 1][j], dp[i][j - 1]，所以 i 和 j 的遍历顺序肯定是从小到大的。
 *      由于当 i 和 jj取值为 0 的时候，dp[i][j] = 0，而 dp 数组本身初始化就是为 0，所以，直接让 ii 和 jj 从 1 开始遍历。
 *      遍历的结束应该是字符串的长度为 len(str1) 和 len(str2)。
 *
 *  ⑤：最终结果返回：
 *      return dp[str1.length() , str2.length()]
 * @author GNMD
 */
public class LongestCommonSubsequence{
    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequence("abcde", "bd"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int [][] dp = new int[m+1][n+1];
        for(int i = 1 ; i <= m ; i ++){
            for(int j = 1 ; j <= n ; j ++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
