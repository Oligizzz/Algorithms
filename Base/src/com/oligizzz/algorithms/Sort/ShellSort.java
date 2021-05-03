package com.oligizzz.algorithms.Sort;

import com.oligizzz.algorithms.Sort.utils.BaseSort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/25
 * @Modify By:
 */
public class ShellSort extends BaseSort {
    public static void main(String[] args) {
        int[] test = BaseSort.array_Test;
        System.out.println("排序前数组：");
        System.out.println(Arrays.toString(test));
        System.out.println("排序后数组：");
        ShellSort shellSort = new ShellSort();
        shellSort.shellSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void shellSort(int[] array) {
        int len = array.length;
        int h = 1;
        while (h < len / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    this.swap(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
