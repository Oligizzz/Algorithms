package com.oligizzz.algorithms.Easy;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/29
 * @Modify By:
 */
public class LeetCode168 {
    public static void main(String[] args) {
        System.out.println(LeetCode168.convertToTitle(1));
    }
    public static String convertToTitle(int columnNumber) {
        int a = columnNumber/26;
        int b = columnNumber%26;
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < a ; i++){
            res.append("A");
        }
        res.append((char)('A'+b-1));
        return res.toString();
    }
}
