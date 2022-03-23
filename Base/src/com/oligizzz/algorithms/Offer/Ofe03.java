package com.oligizzz.algorithms.Offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe03 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (set.contains(a)) {
                return a;
            }
            set.add(a);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
