package com.oligizzz.algorithms.Tree;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/12
 * @Modify By:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
