package com.oligizzz.algorithms.Sort.utils;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/25
 * @Modify By:
 */
public interface Sortab {
        /**
         * 基础排序
         * @param array
         */
        void sort(int [] array);

        /**
         * 比较两个数的大小
         * @param a
         * @param b
         * @return 是否小于
         */
        boolean less(int a, int b);

        /**
         * 数组是否已经排序
         * @param array
         * @return
         */
        boolean isSorted(int [] array);

        /**
         * 数组array'中两个位置
         * @param array 数组
         * @param index1 下标一
         * @param index2 下标二
         */
        void swap(int [] array, int index1 , int index2);
}
