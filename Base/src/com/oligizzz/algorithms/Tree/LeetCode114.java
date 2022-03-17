package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: KXiao
 * @Date: 2022/3/17 22:03
 * @Description:
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {
        if (root == null || root.left == null) {
            return;
        }
        List<TreeNode> list = preorderIterator(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }

    }


    private void preOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    /**
     * 二叉树先序遍历
     *
     * @param root
     * @return
     */
    private List<TreeNode> preorderIterator(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }
}
