package com.oligizzz.algorithms.Backtracking;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
。
 * @Date: 2021/4/11
 * @Modify By:
 */
public class LeetCode47 {
    public static void main(String[] args) {
        System.out.println(new LeetCode47().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len <1 ){return  res; }
        Arrays.sort(nums);
        boolean [] used = new boolean[len];
        dfs(nums,len,new ArrayDeque<>(),used,res);
        return res;
    }

    private void dfs(int [] nums , int len ,Deque<Integer> path , boolean [] used , List<List<Integer>> res){
        if(path.size() == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0 ; i < len ; i++){
            if(used[i]){continue;}
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums,len , path,used,res);
            path.removeLast();
            used[i] = false;
        }
    }
}
