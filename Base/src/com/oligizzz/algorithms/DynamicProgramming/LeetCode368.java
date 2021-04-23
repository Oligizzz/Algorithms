package com.oligizzz.algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/23
 * @Modify By:
 */
public class LeetCode368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int [] dp = new int[len];
        Arrays.fill(nums,1);
        int maxSize = 1 ;
        int maxVal = nums[0];
        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }

            if(dp[i]>maxSize){
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }


        List<Integer> res = new ArrayList<>();

        for(int k = len - 1; k >=0 ; k--){
            if (dp[k] == maxSize && maxVal % nums[k] == 0) {
                res.add(nums[k]);
                maxVal = nums[k];
                maxSize--;
            }
        }
        return res;
    }
}
