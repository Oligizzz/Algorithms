package com.oligizzz.algorithms.Sort;

import com.oligizzz.algorithms.Sort.utils.BaseSort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/25
 * @Modify By:
 */
public class InsertSort extends BaseSort {
        public static void main(String[] args) {
                int[] test = BaseSort.array_Test;
                System.out.println("排序前数组：");
                System.out.println(Arrays.toString(test));
                System.out.println("排序后数组：");
                InsertSort insertSort = new InsertSort();
                insertSort.insertSort1(test);
                System.out.println(Arrays.toString(test));
        }


        /**
         * @param array
         */
          public void insertSort1(int[] array) {
                int len = array.length;
                for (int i = 1; i < len; i++) {
                        for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                                this.swap(array, j, j - 1);
                        }
                }
        }
}
