package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/10
 * @Modify By:
 */
public class LeetCode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);
    }

    private void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }

        dfs(node.left, path);
        if (node != null && node.left == null && node.right == null) {
            path.add(node.val);
        }
        dfs(node.right, path);
    }
}
