package com.oligizzz.algorithms.BitOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/12
 * @Modify By:
 */
public class LeetCode1310 {
    int[] arr;

    public static void main(String[] args) {
        LeetCode1310 leetCode1310 = new LeetCode1310();
        int []a = new int[]{4,8,2,10};
        int [][] b = new int[][]{{2,3},{1,3},{0,0},{0,3}};
        System.out.println(Arrays.toString(leetCode1310.xorQueries(a, b)));
    }

    public int[] xorQueries(int[] _arr, int[][] queries) {
        arr = _arr;
        List<Integer> res = new ArrayList<>();
        for (int[] a : queries) {
            if (a[0] == a[1]) {
                res.add(arr[a[0]]);
            } else {
                res.add(help(a[0], a[1]));
            }
        }
        int[] temp = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            temp[i] = res.get(i);
        }
        return temp;
    }

    private int help(int lo, int hi) {
        int res = 0;
        for (int i = lo; i <= hi;i++) {
            res ^= arr[i];
        }
        return res;
    }


}
