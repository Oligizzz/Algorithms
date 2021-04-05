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
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if(len == 0){
            return res;
        }

        //标记每个元素是否使用过
        boolean [] used = new boolean[len];
        //从根节点到叶子节点的路径
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums,0,path,res);
        return res;
    }

    /**
     * 深度优先遍历，特定情况下剪枝
     * @param nums 待选集合
     * @param start 当前深度
     * @param path 根节点到叶子节点的路径
     * @param res 结果集
     */
    private void dfs(int [] nums, int start,Deque<Integer> path , List<List<Integer>> res){

        res.add(new ArrayList<>(path));
        for(int i = start ; i < nums.length ; i ++){
            path.add(nums[i]);
            dfs(nums,start+1,path,res);
            path.removeLast();
        }
    }
}
