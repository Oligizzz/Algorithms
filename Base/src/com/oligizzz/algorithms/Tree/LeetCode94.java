package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/12
 * @Modify By:
 */
public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){ return res;}
        dfs(root,res);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if(root == null){return;}
        dfs(root.left,res);
        res.add(root.val);
        dfs(root.right,res);
    }
}
