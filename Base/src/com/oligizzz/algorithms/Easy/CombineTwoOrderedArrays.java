package com.oligizzz.algorithms.Easy;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/5
 * @Modify By:
 */
public class CombineTwoOrderedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i <  n ; i++){
            nums1[m+i] = nums2[i];
            for(int j = m +i ; j > 0 && nums1[j] <nums1[j -1] ; j--){
                swap(nums1,j , j -1);
            }
        }
    }

    private void swap(int[] nums1, int j, int i) {
        int temp = nums1[j];
        nums1[j] = nums1[j-1];
        nums1[j -1] = temp;
    }
}
