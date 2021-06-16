package com.oligizzz.integration.DFS.路径问题;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/14
 * @Modify By:
 */
public class Offer13 {
    int k;
    int m;
    int n;
    int res;
    public int movingCount(int _m, int _n, int _k) {
        k = _k;
        m = _m;
        n = _n;
        boolean[][] used = new boolean[m][n];
        dfs(0, 0, 0, used);
        return res;
    }

    private void dfs(int i, int j, int cur, boolean[][] used) {
        // 剪枝条件
        if (i < 0 || i >= m || j < 0 || j >= n || !isLegal(i, j) || used[i][j]) {
            return;
        }
        used[i][j] = true;
        res++;
        dfs(i, j + 1, cur + 1, used);
        dfs(i, j - 1, cur + 1, used);
        dfs(i + 1, j, cur + 1, used);
        dfs(i - 1, j, cur + 1, used);
    }

    private boolean isLegal(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }
}
