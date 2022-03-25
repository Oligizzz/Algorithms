package com.oligizzz.algorithms.Offer;

import com.oligizzz.Base.Tree.TreeNode;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe27 {

    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }
}
