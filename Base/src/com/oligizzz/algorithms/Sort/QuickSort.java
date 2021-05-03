package com.oligizzz.algorithms.Sort;

import com.oligizzz.algorithms.Sort.utils.BaseSort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 快速排序
 * @Date: 2021/5/3
 * @Modify By:
 */
public class QuickSort extends BaseSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int [] test = BaseSort.array_Test;
        System.out.println("排序前："+ Arrays.toString(test));
        quickSort.sort(test,0,test.length-1);
        System.out.println("排序后："+Arrays.toString(test));
    }

    /**
     * @param arr 待排序树组
     * @param lo  左边界
     * @param hi  右边界
     */
    public void sort(int[] arr, int lo, int hi) {
        //递归出口
        if (lo >= hi) {
            return;
        }

        //寻找切分点
        int j = partition(arr, lo, hi);
        // 递归左半部分排序
        sort(arr, lo, j - 1);
        //递归右半部分排序
        sort(arr, j + 1, hi);
    }

    /**
     * 寻找切分点
     *
     * @param arr 待排序数组
     * @param lo  左边界
     * @param hi  右边界
     * @return 切分点，最后在数组中确定的位置
     */
    private int partition(int[] arr, int lo, int hi) {
        //左哨兵
        int i = lo;
        //右哨兵
        int j = hi + 1;

        //参考元素
        int v = arr[lo];
        while (true) {
            // 从左边找到第一个大于参考元素的
            while (arr[++i] < v) {
                if (i == hi) {
                    break;
                }
            }

            //从右边找到第一个小于参考元素的
            while (v < arr[--j]) {
                if (j == lo) {
                    break;
                }
            }

            //哨兵相遇或者越界说明两边的数组都已经处理完了，可以结束循环
            if (i >= j) {
                break;
            }

            //交换两个哨兵元素的位置，因为它们的位置是不合法的
            this.swap(arr, i, j);
        }
        //把参考元素放到正确位置：
        this.swap(arr, lo, j);
        //右边哨兵
        return j;
    }
}
