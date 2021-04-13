package com.oligizzz.algorithms.Tree;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/13
 * @Modify By:
 */
public class LeetCode783 {
    private int res = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(pre != null){ res = Math.min(res,root.val-pre.val);}
        pre = root;
        dfs(root.right);
    }
}
