package com.oligizzz.algorithms.Sort;

import com.oligizzz.algorithms.Sort.utils.BaseSort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/26
 * @Modify By:
 */


public class MergeSort extends BaseSort {


    public static void main(String[] args) {
        int[] test = BaseSort.array_Test;
        mergeSort(test, 0, test.length - 1);
        System.out.println(Arrays.toString(test));
    }

    private static void mergeSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid);
        mergeSort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private static void merge(int[] array, int lo, int mid, int hi) {
        int[] nums = new int[hi - lo + 1];
        int index = 0;

        int p = lo;
        int q = mid + 1;

        while (p <= mid && q <= hi) {
            if (array[p] > array[q]) {
                nums[index++] = array[q++];
            } else {
                nums[index++] = array[p++];
            }
        }

        while (p <= mid) {
            nums[index++] = array[p++];
        }

        while (q <= hi) {
            nums[index++] = array[q++];
        }

        System.arraycopy(nums, 0, array, lo, hi - lo + 1);
    }

}
