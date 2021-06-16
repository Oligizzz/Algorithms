package com.oligizzz.algorithms.Competition;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/23
 * @Modify By:
 */
public class LeetCode5764 {
    public static void main(String[] args) {
        LeetCode5764 leetCode5764 = new LeetCode5764();
        System.out.println(leetCode5764.minSpeedOnTime(new int[]{1, 3, 2}, 6));

    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int len = dist.length;
        if (hour < len - 1) {
            return -1;
        }
        //最低时速
        int lo = dist[0];
        //最高时速
        int hi = dist[0];

        for (int nums : dist) {
            lo = Math.min(nums, lo);
            hi = Math.max(nums, hi);
        }

        while (lo < hi) {

            int mid = lo + (hi - lo >> 1);
            //如果当前速度能到达，保留当前，尝试寻找更慢速度
            int need = need(dist, mid);
            if (need <= hour) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return hi;

    }

    private int need(int[] nums, int speed) {
        int time = 0;
        for (int a : nums) {
            int temp = (int) Math.ceil(a / (speed+0.0));
//            System.out.println(a+" "+speed+" "+temp);
            time += temp;
        }
        return time;
    }
}
