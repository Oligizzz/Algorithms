package com.oligizzz.algorithms.BinarySearch;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/16
 * @Modify By:
 */
public class Offer53 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 2}, 2));
    }
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int res = 0;
        int lo = 0;
        int index = -1;
        int hi = len -1;
        // 先找到这个数
        while(lo <= hi){
            int mid = lo + (hi - lo )/2;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid]>target){
                hi = mid -1;
            }else{
                lo = mid +1;
            }
        }
        // 是否存在这个数
        if(index != -1){
            res = 1;
            // 向左边拓展
            int l = index -1;
            while(l >=0 && nums[l] == target){
                res++;
                l--;
            }
            int r = index +1;
            while(r<len && nums[r] == target){
                res++;
                r++;
            }
            return res;
        }else{
            return 0;
        }

    }
}
