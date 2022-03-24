package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class LeetCode661 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        LeetCode661 test = new LeetCode661();
        int[][] res = test.imageSmoother(arr);
        for (int[] a : res) {
            System.out.println(Arrays.toString(a));
        }

    }


    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] res = new int[m][n];
        int[][] dor = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = img[i][j];
                int count = 1;
                for (int[] a : dor) {
                    int x = i + a[0], y = j + a[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += img[x][y];
                        count++;
                    }
                }
                res[i][j] = sum / count;

            }
        }
        return res;
    }

}
