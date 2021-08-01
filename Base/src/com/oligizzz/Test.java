package com.oligizzz;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/31
 * @Modify By:
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.titleToNumber("ZY"));
    }

    public int titleToNumber(String columnTitle) {
        char[] temp = new StringBuilder(columnTitle).reverse().toString().toCharArray();
        int res =0;
        int t = 0;
        for (int i = 0; i < temp.length; i++) {
            res+=(temp[i]-'@')*Math.pow(26,i);
        }
        return res;
    }
}
