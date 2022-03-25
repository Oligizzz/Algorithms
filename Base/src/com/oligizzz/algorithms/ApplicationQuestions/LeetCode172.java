package com.oligizzz.algorithms.ApplicationQuestions;

/**
 * @author: chunzhao
 * @time: 2022/3/25
 * 1 2 3 4 5
 * 24 * 5 = 20 + 100
 */
public class LeetCode172 {
    public static void main(String[] args) {
        LeetCode172 test = new LeetCode172();
        System.out.println(test.trailingZeroes(13));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
