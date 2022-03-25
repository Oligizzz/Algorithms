package com.oligizzz.algorithms.Offer;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 * <p>
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配
 * <p>
 * aaa ab*ac*a
 */
public class Ofe19 {
    public static void main(String[] args) {
        System.out.println(new Ofe19().isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = i == 0;
                } else {
                    if (p.charAt(j - 1) != '*') {
                        if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    } else {
                        if (j >= 2) {
                            dp[i][j] |= dp[i][j - 2];
                        }
                        if (j >= 2 && i >= 1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    }
                }
            }
        }
        for (boolean[] b : dp) {
            System.out.println(Arrays.toString(b));
        }
        return dp[m][n];
    }
}
