package com.oligizzz.algorithms.Offer;

import com.oligizzz.Base.Tree.TreeNode;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }


    private boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null || a.val != b.val) {
            return false;
        }
        return check(a.left, b.right) && check(a.right, b.left);
    }
}
