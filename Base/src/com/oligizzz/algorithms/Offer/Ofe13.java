package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe13 {
    public static void main(String[] args) {
        Ofe13 test = new Ofe13();
        System.out.println(test.movingCount(7, 2, 3));
    }

    int m, n, k, res = 0;

    public int movingCount(int _m, int _n, int _k) {
        dfs(0, 0, 0, new boolean[m][n]);
        return res;
    }

    private void dfs(int i, int j, int cur, boolean[][] used) {
        if (i < 0 || i >= m || j < 0 || j >= n || used[i][j] || !check(i, j)) {
            return;
        }
        used[i][j] = true;
        res++;
        dfs(i, j + 1, cur + 1, used);
        dfs(i, j - 1, cur + 1, used);
        dfs(i + 1, j, cur + 1, used);
        dfs(i - 1, j, cur + 1, used);
    }

    private boolean check(int i, int j) {
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
