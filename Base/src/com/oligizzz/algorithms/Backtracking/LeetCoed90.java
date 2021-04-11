package com.oligizzz.algorithms.Backtracking;

import java.util.*;
import java.util.stream.LongStream;

/**
 * @Author: GNMD
 * @Description: 回溯入门
 * @Date: 2021/3/31
 * @Modify By:
 */
public class LeetCoed90 {
    public static void main(String[] args) {
        LeetCoed90 lc = new LeetCoed90();
        int [] nums = new int[]{1,2,3};
        List<List<Integer>> res = lc.subsetsWithDup(nums);
        System.out.println(res.toString());
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length < 1){ return res;}
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums,path,0,res);
        return res;
    }

    private void dfs(int [] nums, Deque<Integer> path , int index , List<List<Integer>> res) {
        if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;}

        path.add(nums[index]);
        dfs(nums,path,index+1,res);
        path.removeLast();
        while(index+1 <nums.length && nums[index] == nums[index+1]){
            index++;
        }
        dfs(nums,path,index+1,res);
    }
}
