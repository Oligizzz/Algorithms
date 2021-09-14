package com.oligizzz.algorithms.String;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/13
 * @Modify By:
 */
public class LeetCode678 {

    public static void main(String[] args) {
        System.out.println(LeetCode678.checkValidString("()"));
        System.out.println((int)'(');
        System.out.println((int)')');
        System.out.println((int)'*');
        System.out.println(40&3);
        System.out.println(41&3);
        System.out.println(42&3);
    }
    public static boolean checkValidString(String s) {
        int l = 0;
        for (int n = s.length(), i = 0, x = 0, y; i < n; ++i) {
            y = s.charAt(i) & 3;
            l -= y;
            if (y == 1) {
                if (--x < 0) {
                    return false;
                }
            } else {
                ++x;
                ++l;
            }
            if (l < 0) {
                l = 0;
            }
        }
        return l == 0;
    }
}
