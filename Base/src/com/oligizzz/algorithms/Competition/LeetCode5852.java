package com.oligizzz.algorithms.Competition;

import java.util.Arrays;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/22
 * @Modify By:
 */
public class LeetCode5852 {
    public static void main(String[] args) {
        LeetCode5852 test = new LeetCode5852();
        System.out.println(test.minimizeTheDifference(new int[][]{{3,5},{5,10}}, 47));
    }

    int res = Integer.MAX_VALUE;
    int target;
    int[][] nums;

    public int minimizeTheDifference(int[][] mat, int _target) {
        nums = mat;
        target = _target;
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0 ; i< m ; i++){
            Arrays.sort(nums[i]);
        }
        dfs(m, n, 0, 0);
        return res;
    }


    private void dfs(int m, int n, int row, int sum) {
        if (row == m) {
            res = Math.min(res, Math.abs(target - sum));
            return;
        }
        if(res == 0){return;}
        for (int i = 0; i < n; i++) {
            sum += nums[row][i];
            dfs(m, n, row + 1, sum);
            sum -= nums[row][i];
        }
    }
}
