package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/23
 * @Modify By:
 */
public class LeetCode5763 {
    public static void main(String[] args) {
        LeetCode5763 leetCode5763 = new LeetCode5763();
        System.out.println(leetCode5763.checkZeroOnes("1101"));
    }

    public boolean checkZeroOnes(String s) {
        int len = s.length();
        if (len == 1) {
            return "1".equals(s) ? true : false;
        }
        int i = 0;
        int j = 1;
        int res1 = 0;
        int res2 = 0;
        int a = 0;
        int b = 0;
        char pre = s.charAt(i);
        while (j < len) {
            char cur = s.charAt(j);
            if (cur == pre) {
                if (pre == '0') {
                    a++;
                    res1 = Math.max(res1, a);
                } else {
                    b++;
                    res2 = Math.max(res2, b);
                }
                j++;
            } else {
                i = j;
                a = 0;
                b = 0;
                pre = cur;
                j++;
            }
        }
        return res2 > res1;
    }
}
