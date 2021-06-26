package com.oligizzz.algorithms.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: 
 * @Description:
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]

 * @Date: 2021/4/11
 * @Modify By:
 */
public class LeetCode46 {
    public static void main(String[] args) {
        System.out.println(new LeetCode46().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length<1){ return res;}
        dfs(nums,new ArrayDeque<>(),new boolean[nums.length],res);
        return res;
    }

    private void dfs(int [] nums, Deque<Integer> path , boolean [] used , List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0 ; i <nums.length ; i++){
            if(used[i]){continue;}
            used[i] = true;
            path.add(nums[i]);
            dfs(nums,path,used,res);
            used[i] = false;
            path.removeLast();
        }
    }
}
