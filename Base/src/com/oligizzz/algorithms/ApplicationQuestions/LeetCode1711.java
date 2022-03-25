package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description: 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 * <p>
 * 你可以搭配 任意 两道餐品做一顿大餐。
 * <p>
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 * @Date: 2021/7/7
 * @Modify By:
 */
public class LeetCode1711 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 3, 5, 7, 9};
        System.out.println(countPairs(test));
    }

    static int mod = (int) 1e9 + 7;

    public static int countPairs(int[] ds) {
        int n = ds.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = ds[i];
            for (int other : map.keySet()) {
                int cur = x + other;
                if ((cur & (cur - 1)) == 0) {
                    ans += map.get(other);
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return (int) ans % mod;

    }
}
