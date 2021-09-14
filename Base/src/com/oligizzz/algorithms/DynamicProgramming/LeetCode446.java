package com.oligizzz.algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/11
 * @Modify By:
 */
public class LeetCode446 {
    public static void main(String[] args) {
        LeetCode446 test = new LeetCode446();
        System.out.println(test.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        Set<Integer> steps = new HashSet<>();
        for (int num : nums) {
            steps.add(num);
        }
        int[] map = new int[steps.size()];
        int index = 0;
        Iterator<Integer> iterator = steps.iterator();
        while (iterator.hasNext()) {
            map[index++] = iterator.next();
        }

        int[][] dp = new int[len + 1][map.length];
        for (int i = 0; i < map.length; i++) {
            int temp = map[i];
            if (nums[1] - nums[0] == temp && nums[2] - nums[1] == temp) {
                dp[2][i] = 1;
            }
        }

        for (int i = 3; i < len; i++) {
            for (int j = 0; j < map.length; j++) {
                for (int k = 2; k <= i - 1; k++) {
                    dp[i][j] += dp[k][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < map.length; i++) {
            res += dp[len][i];
        }
        for(int i = 0 ; i< len ; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return res;
    }
}
