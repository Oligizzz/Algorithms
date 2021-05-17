package com.oligizzz.algorithms.BitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/16
 * @Modify By:
 */
public class LeetCode421 {

    public static void main(String[] args) {
        LeetCode421 leetCode421 = new LeetCode421();
        List<Integer> res = leetCode421.findMaximumXOR(new int[]{1,2,3,4,5,6,7,8,9,10});
       // System.out.println(res);
        System.out.println(5^8);
    }

    public List<Integer> findMaximumXOR(int[] nums) {
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                path.add(nums[i]^nums[j]);
            }
            path.add(null);
        }
        return path;
    }
}
