package com.oligizzz.algorithms.Competition;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/16
 * @Modify By:
 */
public class LeetCode5759 {
    public static void main(String[] args) {
        LeetCode5759 leetCode5759 = new LeetCode5759();
        System.out.println(leetCode5759.subsetXORSum(new int[]{5, 1, 6}));
    }
    int res = 0;
    public int subsetXORSum(int[] nums) {

        if(nums.length == 0){ return res;}
        if(nums.length<2){ return nums[0];}
        dfs(nums,nums.length,0,new ArrayDeque<>());
        return res;
    }

    private void dfs(int [] nums , int len , int index, Deque<Integer> path){
        if(index == len  ){
            res += get(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(nums,len ,index+1,path);
        path.removeLast();
        dfs(nums,len ,index+1,path);

    }

    private int get(List<Integer> path){
        if(path.size() == 0){return 0;}
        int temp = 0;
        for(Integer i : path){
            temp^=i;
        }
        return temp;
    }
}
