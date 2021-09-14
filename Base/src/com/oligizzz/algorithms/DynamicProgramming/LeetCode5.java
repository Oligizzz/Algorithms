package com.oligizzz.algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/27
 * @Modify By:
 */
public class LeetCode5 {
    public static void main(String[] args) {
        System.out.println(LeetCode5.longestPalindrome2("babad"));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (j - i == 1 && arr[i] == arr[j]) {
                    dp[i][j] = true;
                }
                if (j - i >= 2 && arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        int lo = 0;
        int hi = 0;
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(dp[i]));
            for (int j = i; j < len; j++) {
                if (dp[i][j] && j - i > hi - lo) {
                    lo = i;
                    hi = j;
                }
            }
        }
        return s.substring(lo, hi + 1);
    }

    public static String longestPalindrome2(String s) {
        int max = 0;
        String res = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (check(temp) && j - i > max) {
                    max = j - i;
                    res = temp;
                }
            }
        }
        return res;
    }


    private static boolean check(String s) {
        char[] temp = s.toCharArray();
        int i = 0;
        int j = temp.length - 1;
        while (i <= j) {
            if (temp[i] != temp[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
