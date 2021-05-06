package com.oligizzz.algorithms.Backtracking;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/5
 * @Modify By:
 */
public class LeetCode740 {
    public int res = 0;
    public int deleteAndEarn(int[] nums) {
        int len = nums.length;
        boolean [] deleted = new boolean[len];
        dfs(nums,deleted,len , 0,0 , 0);
        return res;
    }

    private void dfs(int [] nums,boolean [] deleted , int len ,int temp, int cur,int start){
        if(len == temp){
            res = Math.max(res , cur);
            return;
        }

        for(int i = start ; i < len ; i ++){
            if(deleted[i]){
                temp++;
                continue;
            }

            cur+=nums[i];
            temp++;
            deleted[i] = true;
            for(int j = 0 ; j < len ; j ++){
                if(!deleted[j]&&(nums[i]-1 == nums[j]|| nums[i]+1 == nums[j])){
                    deleted[j] = true;
                    temp++;
                }

            }
            dfs(nums,deleted,len,temp,cur,i+1);
        }
    }

    public static void main(String[] args) {
        LeetCode740 leetCode740 = new LeetCode740();
        System.out.println(leetCode740.deleteAndEarn(new int[]{3, 4, 2}));
    }
}
