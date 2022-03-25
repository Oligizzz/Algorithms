package com.oligizzz.algorithms.DoublePointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chunzhao
 * @time: 2022/3/22
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 * [1,2,3,4,5,6,3,8,7,6]
 * [1,2,3,4,5] -> (5-3+1)+(5-4+1)+(5-5+1) --> (n+1 ->)
 * [1,2,3]
 * [2,3,4]
 * [3,4,5]
 * [1,2,3,4]
 * [2,3,4,5]
 * [1,2,3,4,5]
 */
public class LeetCode413 {
    public static void main(String[] args) {
        LeetCode413 test = new LeetCode413();
        System.out.println(test.numberOfArithmeticSlices(new int[]{1, 2, 3, 3, 8, 7, 6}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length, res = 0;
        if (len < 3) {
            return 0;
        }
        int[] difference = new int[len - 1];
        int index = 0;
        for (int i = 1; i < len; i++) {
            difference[index++] = nums[i] - nums[i - 1];
        }
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int i = 1; i < difference.length; i++) {
            if (difference[i] == difference[i - 1]) {
                count++;
            } else {
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        for (Integer a : list) {
            if (a > 1) {
                res += getCount(a + 1);
            }
        }
        return res;
    }

    private int getCount(int len) {
        int res = 0;
        for (int i = 3; i <= len; i++) {
            res += len + 1 - i;
        }
        return res;
    }
}
