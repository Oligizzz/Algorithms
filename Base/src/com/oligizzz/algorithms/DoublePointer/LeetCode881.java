package com.oligizzz.algorithms.DoublePointer;

import java.util.Arrays;

/**
 * @Author: Oligizzz
 * @Description: 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * https://leetcode-cn.com/problems/boats-to-save-people/
 * @Date: 2021/8/26
 * @Modify By:
 */
public class LeetCode881 {
    public static void main(String[] args) {
        System.out.println(LeetCode881.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        int len = people.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            if (people[lo] + people[hi] <= limit) {
                lo++;
            }
            hi--;
            res++;
        }
        return res;
    }

}
