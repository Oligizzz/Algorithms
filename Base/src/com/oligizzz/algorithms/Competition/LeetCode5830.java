package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/1
 * @Modify By:
 */
public class LeetCode5830 {

    public static void main(String[] args) {
        LeetCode5830 test = new LeetCode5830();
        System.out.println(test.isThree(1));
    }
    public boolean isThree(int n) {
        return count(n)==3;
    }

    private int count(int n) {
        int s = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int a = 0;
                while (n % i == 0) {
                    n /= i;
                    a++;
                }
                s = s * (a + 1);
            }
        }
        if (n > 1) {
            s = s * 2;
        }
        return s;
    }
}

