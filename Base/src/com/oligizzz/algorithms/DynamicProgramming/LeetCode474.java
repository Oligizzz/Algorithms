package com.oligizzz.algorithms.DynamicProgramming;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/6
 * @Modify By:
 */
public class LeetCode474 {

    static int[][] a = new int[4][601];

    public int findMaxForm(String[] strs, int m, int n) {
        int[] b = new int[]{n, m, m, n, n, m, m, n};
        int ss = strs.length, res = 0, x1 = 0, y1 = 0;
        for (int i = 0, x, y, z, j; i < ss; ++i) {
            String s = strs[i];
            for (z = y = s.length(), x = 0, j = 0; j < y; x += s.charAt(j++) & 1) {
            }
            x1 += x;
            y1 += y -= x;
            a[0][i] = (x << 7) + y;
            a[1][i] = (y << 7) + x;
            a[2][i] = (z << 16) + (x << 7) + y;
            a[3][i] = (z << 16) + (y << 7) + x;
            if (y == 0 || y == z) {
                z <<= 16;
                a[0][i] += z;
                a[1][i] += z;
                a[2][i] += z;
                a[3][i] += z;
            }
        }
        if (x1 == 0 || y1 == 0) {
            return 0;
        }
        Arrays.sort(a[0], 0, ss);
        Arrays.sort(a[1], 0, ss);
        Arrays.sort(a[2], 0, ss);
        Arrays.sort(a[3], 0, ss);
        for (int j = 8, i, x, y, z, l = 0; 0 != j--; ++l) {
            for (i = 0, z = 0, n = b[j--], m = b[j]; i < ss; ++i) {
                x = (a[l][i] >> 7) & 127;
                y = a[l][i] & 127;
                if (x <= n && y <= m) {
                    m -= y;
                    n -= x;
                    ++z;
                }
            }
            if (z > res) {
                res = z;
            }
        }
        return res;
    }
}
