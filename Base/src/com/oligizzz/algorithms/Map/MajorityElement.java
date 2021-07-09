package com.oligizzz.algorithms.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/9
 * @Modify By:
 */
public class MajorityElement {
    public int majorityElement1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int a : nums){
            map.put(a,map.getOrDefault(a,0)+1);
            if (map.get(a) > nums.length / 2) {
                return a;
            }
        }

        return -1;
    }
}
