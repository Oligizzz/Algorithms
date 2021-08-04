package com.oligizzz.algorithms.Competition;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/1
 * @Modify By:
 */
public class LeetCode5831 {
    public static void main(String[] args) {
        LeetCode5831 test = new LeetCode5831();
        System.out.println(test.numberOfWeeks(new int[]{5,9,4,4,8,9,9,8,7,3}));
    }

    public long numberOfWeeks(int[] milestones) {
        long res = 0;
        Arrays.sort(milestones);
        int len = milestones.length;
        if (len < 2) {
            return 1;
        }

        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            while(lo<=hi && milestones[lo] == 0){
                lo++;
            }
            for (int i = lo; i <= hi; i++) {
                milestones[i]--;
                res++;
            }
        }
        if (milestones[hi] > 0) {
            return res + 1;
        }
        return res;
    }
}
