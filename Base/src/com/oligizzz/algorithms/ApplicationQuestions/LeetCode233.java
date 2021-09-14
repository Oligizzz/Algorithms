package com.oligizzz.algorithms.ApplicationQuestions;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/13
 * @Modify By:
 */
public class LeetCode233 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(824883294));
        System.out.println(countDigitOne2(824883294));
    }

    public static int countDigitOne(int n) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += help(i);
        }
        return res;
    }

    private static int help(int n) {
        int res = 0;
        while (n > 0) {
            res += n % 10 == 1 ? 1 : 0;
            n /= 10;
        }
        return res;
    }

    public static int countDigitOne2(int n) {
        int res = 0;
        // 位数标记，初始化为个位
        int digit = 1;
        //当前高位
        int high = n / 10;
        // 当前位
        int cur = n % 10;
        // 当前低位
        int low = 0;

        while (high != 0 || cur != 0) {
            // 如果当前位是0
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }

        return res;

    }

}
