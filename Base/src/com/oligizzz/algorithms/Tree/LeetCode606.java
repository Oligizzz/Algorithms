package com.oligizzz.algorithms.Tree;

import com.oligizzz.Base.Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: chunzhao
 * @time: 2022/3/19
 */
public class LeetCode606 {
    public static void main(String[] args) {
        LeetCode606 test = new LeetCode606();
        System.out.println(test.tree2str(TreeNode.DEFAULT_TREE));
    }

    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfs(TreeNode.DEFAULT_TREE, res);
        return res.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) {
            dfs(root.left, sb);
        } else if (root.right != null) {
            sb.append("()");
        }
        if (root.right != null) {
            dfs(root.right, sb);
        }
        sb.append(")");
    }


    private List<String> layerOrder(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode child = queue.poll();
                assert child != null;
                temp.add("(" + child.val + ")");
                if (child.left != null) {
                    queue.offer(child.left);
                }
                if (child.right != null) {
                    queue.offer(child.right);
                }
            }
            StringBuilder layer = new StringBuilder();
            for (String s : temp) {
                layer.append(s);
            }
            res.add("(" + layer.toString() + ")");
        }
        return res;
    }


}
