package com.oligizzz.algorithms.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/8
 * @Modify By:
 */
public class LeetCode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        //前缀和
        int sum = 0;;
        for(int num : nums){
            map.put(sum,map.getOrDefault(sum,0)+1);
            sum+=num;
            res+=map.getOrDefault(sum-goal,0);
        }
        return res;
    }
}
