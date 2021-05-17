package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/9
 * @Modify By:
 */
public class LeetCode5751 {
    public static void main(String[] args) {
        int [] a= new int[]{55,30,5,4,2};
        int [] b = new int[]{100,20,10,10,5,1,0};
        LeetCode5751 leetCode5751 = new LeetCode5751();
        System.out.println(leetCode5751.maxDistance(a, b));
    }

    public int maxDistance(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        while(i < len2 && nums2[i]>=nums1[0]){
            i++;
        }
        System.out.println();
        return i;


    }
}
