package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/15
 * @Modify By:
 */
public class LeetCode1846 {
    public static void main(String[] args) {
        int [] test = new int[]{1,2,2,2,2,2,2,2,1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(test));
    }
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[n - 1];
    }
}
