package com.oligizzz.algorithms.Search.BinarySerach;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/26
 * @Modify By:
 */
public class Offer04 {

    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();
        offer04.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 5);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo >> 1);
            if (matrix[mid][0] > target) {
               hi = mid - 1;
            } else {
                lo = mid;
            }
        }

        return help(matrix[lo], target);
    }

    private boolean help(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }
}
