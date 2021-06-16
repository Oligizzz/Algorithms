package com.oligizzz.algorithms.BitOperation;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/23
 * @Modify By:
 */
public class LeetCode1707 {
    int [] nums;
    public int[] maximizeXor(int[] _nums, int[][] queries) {
        nums = _nums;
        int m = queries.length;
        int [] res = new int[m];
        for(int i =0 ; i < m ; i ++){
            res[i] = xor(queries[i][0],queries[i][1]);
        }
        return res;
    }

    private int xor(int xi , int mi){
        int max = -1;
        int c = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]<=mi){
                max = Math.max(c^nums[i],c);
            }
        }
        return max;
    }
}
