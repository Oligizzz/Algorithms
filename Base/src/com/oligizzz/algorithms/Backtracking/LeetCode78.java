package com.oligizzz.algorithms.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：

 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @Date: 2021/4/11
 * @Modify By:
 */
public class LeetCode78 {
    public static void main(String[] args) {
        System.out.println(new LeetCode78().subsets(new int[]{1, 2, 3}));
    }
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 1) {return res;}
        dfs(nums,len,new ArrayDeque<>(),0,res);
        return res;
    }

    private void dfs(int [] nums , int len , Deque<Integer> path , int index ,List<List<Integer>> res){
        if(index == len){
            res.add(new ArrayList<>(path));
            return ;
        }
        path.add(nums[index]);
        dfs(nums,len,path,index+1,res);
        path.removeLast();
        dfs(nums,len,path,index+1,res);
    }
}
