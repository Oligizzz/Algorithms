package com.oligizzz.algorithms.Offer;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe21 {
    public static void main(String[] args) {
        Ofe21 test = new Ofe21();
        System.out.println(Arrays.toString(test.exchange(new int[]{1, 2, 3, 4})));
    }

    public int[] exchange(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int i = 0;
        int j = len;
        for (int a : nums) {
            if (a % 2 == 0) {
                res[--j] = a;
            } else {
                res[i++] = a;
            }
        }
        return res;
    }
}
