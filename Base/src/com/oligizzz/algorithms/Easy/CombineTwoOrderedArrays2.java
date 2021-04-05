package com.oligizzz.algorithms.Easy;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/5
 * @Modify By:
 */
public class CombineTwoOrderedArrays2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        int [] nums = new int[m+n];
        int p = 0;
        int q = m;
        int index = 0;

        while(p < m && q < m+n){
            if(nums1[p] <nums1[q]){
                nums[index++] = nums1[p++];
            }else{
                nums[index++] = nums1[q++];
            }
        }

        while( p < m ){
            nums[index++] = nums1[p++];
        }

        while(q < m+n){
            nums[index++] = nums1[q++];
        }
        System.arraycopy(nums,0,nums1,0,m+n);

    }
}
