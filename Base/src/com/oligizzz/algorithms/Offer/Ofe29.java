package com.oligizzz.algorithms.Offer;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 1,2,3,4
 * 5,6,7,8
 * 2,3,4,5
 * 3,4,5,7
 * <p>
 * 1,2,3,4
 * 3,4,6,8
 * 3,5,7,8
 * <p>
 * 1,2,3
 * 4,5,6
 * 7,8,9
 */
public class Ofe29 {
    public static void main(String[] args) {
        Ofe29 test = new Ofe29();
        System.out.println(Arrays.toString(test.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{0};
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] res = new int[(r + 1) * (b + 1)];
        int index = 0;
        for (; ; ) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                res[index++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res[index++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }
            for (int i = b; i >= t; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }
}
