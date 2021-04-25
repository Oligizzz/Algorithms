package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/25
 * @Modify By:
 */
public class LeetCode897 {
    public TreeNode res;
    public TreeNode increasingBST1(TreeNode root) {
        //巴中序遍历的节点全部放在柚子树上
        TreeNode dummyNode = new TreeNode(-1);
        res = dummyNode;
        dfs1(root);
        return dummyNode.right;

    }

    private void dfs1(TreeNode node){
        if(node == null){
            return;
        }
        dfs1(node.left);
        res.right = node;
        node.left = null;
        res = node;
        dfs1(node.right);
    }

    public TreeNode increasingBST2(TreeNode root) {
        //巴中序遍历的节点全部放在柚子树上
        List<TreeNode> temp = new ArrayList<>();
        dfs2(root,temp);
        TreeNode res = new TreeNode(-1);
        TreeNode dummy = res;
        for (TreeNode treeNode : temp) {
            dummy.right = treeNode;
            treeNode.left = null;
            dummy = treeNode;
        }
        return res.right;

    }

    private void dfs2(TreeNode node, List<TreeNode> temp){
        if(node == null){
            return;
        }
        dfs2(node.left,temp);
        temp.add(node);
        dfs2(node.right,temp);
    }


}
