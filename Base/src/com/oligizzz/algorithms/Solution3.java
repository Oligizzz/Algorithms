package com.oligizzz.algorithms;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/29
 * @Modify By:
 */
public class Solution3 {
    public static void main(String[] args) {
        double X = 1.00;
        double T = 1.00;

        //X粒度
        int stepX = 40;
        //T粒度
        int stepT = 3200;
        //X步长
        double h = X / stepX;
        //T步长
        double t = T / stepT;
        //r
        double r = t / (h * h);

        double[][] u = new double[41][3201];

        //初始化 n = 0 行
        for (int j = 0; j <= 40; j++) {
            u[j][0] = Math.cos(Math.PI * j * h);
        }

        //初始化第 j=0 和 j=40 列
        for (int n = 1; n <= 3200; n++) {
            u[0][n] = 2 * r * u[1][n - 1] + (1 - 2 * r) * u[0][n - 1] + Math.sin(t * n) * t;
            u[40][n] = 2 * r * u[39][n - 1] + (1 - 2 * r) * u[40][n - 1] + Math.sin(t * n) * t;
        }


        //中间部分填充
        for (int j = 1; j <= 39; j++) {
            for (int n = 1; n <= 3200; n++) {
                u[j][n] = r * u[j + 1][n - 1] + (1 - 2 * r) * u[j][n - 1] + r * u[j - 1][n - 1] + t * Math.sin(t * n);
            }
        }

        // 打印数组
        for (double[] a : u) {
            System.out.println(toStringTest(a));
        }


    }

    public static String toStringTest(double[] a) {
        DecimalFormat df = new DecimalFormat("#0.000000");
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(df.format(a[i]));
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }
}
