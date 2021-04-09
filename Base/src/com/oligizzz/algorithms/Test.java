package com.oligizzz.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */
public class Test {


    public static void main(String[] args) {
        //int [] test = new int[2147483648];
        System.out.println(Integer.MAX_VALUE);
//        for(int i = 0 ; i < 2147483648 ; i ++){
//            test[i] = i;
//        }
//        Test test1 = new Test();
//        System.out.println(test1.binarySearch1(test, 12));

    }


    private int binarySearch1(int[] nums ,int target){
        int len = nums.length;
        int lo = 0 ;
        int hi = len -1;
        while(lo <= hi){
            int mid = lo + (hi - lo >>1);
            if(nums[mid] == target){ return mid;}
            if(nums[mid]>target){
                hi = mid - 1;
            }else{
                lo = mid +1;
            }
        }
        return -1;
    }


    private int binarySearch2(int [] nums , int target){
        int len = nums.length;
        int lo = 0;
        int hi = len -1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return nums[hi] == target ? hi : -1;
    }
}
