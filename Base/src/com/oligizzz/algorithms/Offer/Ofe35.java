package com.oligizzz.algorithms.Offer;

import com.oligizzz.Base.Tree.TreeNode;

import java.util.*;

/**
 * @author: chunzhao
 * @time: 2022/3/25
 */
public class Ofe35 {
    public static void main(String[] args) {
        Ofe35 test = new Ofe35();
        System.out.println(test.pathSum(TreeNode.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22));
    }


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, new LinkedList<>(), target, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, Deque<Integer> path, int target, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        sum += root.val;
        path.addLast(root.val);
        if (sum == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum, path, target, res);
        dfs(root.right, sum, path, target, res);
        path.removeLast();
    }

}
