package com.oligizzz.summarize.DynamicProgramming.Palindrome;

/**
 * @Author: Oligizzz
 * @Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * @Date: 2021/8/12
 * @Modify By:
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();
        System.out.println(test.longestPalindrome("abccccdd"));
    }
    public int longestPalindrome(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[len][len];
        dp[0][1] = 1;
        for (int i = 1; i <=len; i++) {
            for (int l = 0; l + i < len; l++) {
                int r = l + i -1;
                if(i == 1){
                    dp[l][r] = 1;
                }else if(len == 2){
                    dp[l][r] = arr[l] == arr[r]?2:1;
                }else{
                    dp[l][r] = dp[l+1][r-1]+(arr[l] == arr[r]?2:1);
                }
            }
        }
        return dp[0][len-1];
    }
}
