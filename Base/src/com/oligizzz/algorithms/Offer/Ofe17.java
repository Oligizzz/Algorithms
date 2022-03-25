package com.oligizzz.algorithms.Offer;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe17 {
    public static void main(String[] args) {
        Ofe17 test = new Ofe17();
        System.out.println(Arrays.toString(test.printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = max * 10 + 9;
        }
        int[] res = new int[max];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
