package com.oligizzz.algorithms.DFS;

import com.oligizzz.Base.Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: KXiao
 * @Date: 2022/3/17 23:04
 * @Description:
 */
public class LeetCode113 {


    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> stack = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        stack.offerLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new ArrayList<>(stack));
        }
        dfs(root.left, targetSum);
        dfs(root.right,targetSum);
        stack.pollLast();
    }


}
