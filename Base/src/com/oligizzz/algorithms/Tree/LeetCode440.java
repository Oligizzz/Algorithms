package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 * 给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
 * 1,10,11,110,12,13,14,15,16,17,18,19,2,20,21
 */
public class LeetCode440 {

    int res = 0;

    public static void main(String[] args) {
        LeetCode440 test = new LeetCode440();
        System.out.println(test.findKthNumber(9, 2));
    }

    public int findKthNumber(int n, int k) {
        int count = 0;
        for (int i = 1; i <= 9; i++) {
            dfs(n, k, i, count);
        }
        System.out.println(res);
        return res;
    }

    private void dfs(int n, int k, int cur, int count) {
        if (count == k) {
            res = cur;
            return;
        }
        if (cur > n) {
            return;
        }
        count++;
        for (int i = 0; i <= 9; i++) {
            int next = cur * 10 + i;
            dfs(n, k, next, count);
        }
    }
}
