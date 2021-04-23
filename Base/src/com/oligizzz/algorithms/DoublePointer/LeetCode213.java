package com.oligizzz.algorithms.DoublePointer;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/15
 * @Modify By:
 */
public class LeetCode213 {
    public static void main(String[] args) {
        int [] a = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        LeetCode213 leetCode213 = new LeetCode213();
        leetCode213.rob(a);
        System.out.println(leetCode213.rob2(a));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){ return nums[0];}
        int canSto = len/2;
        int res = 0;
        for(int i = 0 ; i < len ; i ++){
            int max = 0;
            for(int j = 0 ; j < canSto ; j++){
                int index = (i+j*2)%len;
                max+=nums[index];
                System.out.printf(index+ " ");
            }
            res = Math.max(res,max);
            System.out.println(res);
        }
        return res;
    }

    public int rob2(int [] nums){
        int len = nums.length;
        if(len == 0){ return 0;}
        if(len == 1){ return nums[0];}
        return Math.max(help(Arrays.copyOfRange(nums,0,len-1)),help(Arrays.copyOfRange(nums,1,len)));
    }

    private int help (int [] nums){
        int len = nums.length;
        if(len == 0){ return 0;}
        int [] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1 ; i < len ; i ++){
            if(i<2){
                dp[i] = Math.max(dp[i-1],0+nums[i] );
            }else{
                dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
            }
        }
        return dp[len-1];
    }
}
