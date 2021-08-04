package com.oligizzz.algorithms.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: GNMD
 * @Description: 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
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
        List<Integer> path = new ArrayList<>();
        if (len < 1) {
            return res;
        }
        dfs2(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, Deque<Integer> path, int index, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[index]);
        dfs(nums, len, path, index + 1, res);
        path.removeLast();
        dfs(nums, len, path, index + 1, res);
    }

    private void dfs2(int[] nums, int index, List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs2(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }


    private void find(int[] nums, int begin, List<Integer> pre, List<List<Integer>> res) {
        res.add(new ArrayList<>(pre));// 注意：Java 的引用传递机制，这里要 new 一下
        for (int i = begin; i < nums.length; i++) {
            pre.add(nums[i]);
            find(nums, i + 1, pre, res);
            pre.remove(pre.size() - 1);// 组合问题，状态在递归完成后要重置
        }
    }
}
