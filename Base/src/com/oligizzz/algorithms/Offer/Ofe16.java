package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe16 {

    public double myPow(double x, int n) {
        return 1.0;
    }

    private double fastPower(double x, int n) {
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            n >>>= 1;
            x *= x;
        }
        return res;
    }
}
