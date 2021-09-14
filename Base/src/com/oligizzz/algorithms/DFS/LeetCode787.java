package com.oligizzz.algorithms.DFS;

import java.util.Arrays;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/26
 * @Modify By:
 */
public class LeetCode787 {
    int[][] map;
    int K, dst, path, res, cur;

    public int findCheapestPrice(int n, int[][] flights, int src, int _dst, int k) {
        K = k;
        res = Integer.MAX_VALUE;
        cur = 0;
        dst = _dst;
        map = new int[n][n];
        for (int[] temp : map) {
            Arrays.fill(temp, -1);
        }
        for (int[] arr : flights) {
            map[arr[0]][arr[1]] = arr[2];
        }
        dfs(src);
        return res;

    }

    private void dfs(int index) {
        if (index == dst && cur <= K) {
            res = Math.min(res, path);
            return;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[index][i] != -1) {
                path += map[index][i];
                cur++;
                dfs(i);
                path -= map[index][i];
                cur--;
            }
        }
    }
}
