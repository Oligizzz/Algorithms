package com.oligizzz.algorithms.Sort;

import com.oligizzz.algorithms.Sort.utils.BaseSort;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/3/25
 * @Modify By:
 */
public class SelectSort extends BaseSort {
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] test = BaseSort.array_Test;
        System.out.println(Arrays.toString(BaseSort.array_Test));
        selectSort.selectSort(test);
        System.out.println(Arrays.toString(test));

    }

    public void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (this.less(array[j], array[min])) {
                    min = j;
                }
            }
            this.swap(array, i, min);
        }
    }


    public void selectSort2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }
}
