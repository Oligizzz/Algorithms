package com.oligizzz.summarize.Sort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/3
 * @Modify By:
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort test = new QuickSort();
        int[] arr = new int[]{2, 5, 78, 3, 6, 9, 12, 45, 78, 3, 989, 12};
        test.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] temp = nums.clone();
        quickSort(nums, 0, len - 1);
        int lo = 0;
        int hi = len - 1;
        while (lo < len - 1 && temp[lo] == nums[lo]) {
            lo++;
        }
        if (lo == len - 1) {
            return 0;
        }
        while (hi > 0 && temp[hi] == nums[hi]) {
            hi--;
        }
        return hi - lo + 1;
    }


    /**
     * 快速排序
     *
     * @param nums 待排数组
     * @param lo   左边界
     * @param hi   右边界
     */
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int partition = partition(nums, lo, hi);
        quickSort(nums, lo, partition - 1);
        quickSort(nums, partition + 1, hi);
    }

    /**
     * 寻找分割点
     *
     * @param nums 待排数组
     * @param lo   左边界
     * @param hi   右边界
     * @return 分割点
     */
    private int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int reference = nums[lo];
        while (true) {
            //从左边找到第一个比参考元素大的元素
            while (nums[++i] < reference) {
                if (i == hi) {
                    break;
                }
            }

            while (nums[--j] > reference) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            // 交换两个不合法的位置
            swap(nums, i, j);
        }
        //把参考元素放到正确的位置
        swap(nums, lo, j);
        return j;

    }

    /**
     * 数组指定两个位置交换
     *
     * @param nums
     * @param a
     * @param b
     */
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
