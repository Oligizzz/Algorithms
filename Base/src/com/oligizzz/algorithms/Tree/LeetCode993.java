package com.oligizzz.algorithms.Tree;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/17
 * @Modify By:
 */
public class LeetCode993 {
    int x;
    int y;
    int dep1;
    int dep2;
    TreeNode xRoot;
    TreeNode yRoot;

    public boolean isCousins(TreeNode root, int _x, int _y) {
        x = _x;
        y = _y;
        dfs(root, 0);
        System.out.println(xRoot.val + " " + yRoot.val);
        return (xRoot != null && yRoot != null) && (xRoot == yRoot) && (dep1 == dep2);
    }

    private void dfs(TreeNode node, int dep) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            if (node.left.val == x) {
                xRoot = node;
                dep1 = dep + 1;
            }

            if (node.left.val == y) {
                yRoot = node;
                dep2 = dep + 1;
            }
        }
        if (node.right != null) {
            if (node.right.val == x) {
                xRoot = node;
                dep1 = dep + 1;
            }

            if (node.right.val == y) {
                yRoot = node;
                dep2 = dep + 1;
            }
        }

        dfs(node.left, dep + 1);
        dfs(node.right, dep + 1);
    }


    private int[] dfs2(TreeNode root, TreeNode father, int depth, int target) {
        if (root == null) {
            return new int[]{-1, -1};
        }
        //找到目标值
        if (root.val == target) {
            //如果此时父节点为空，表示找到了，但是实在根节点上用 0 打上标记，否则就用根节点的值标记
            return new int[]{father != null ? father.val : 0, depth};
        }
        int[] left = dfs2(root.left, root, depth + 1, target);
        if (left[0] != -1) {
            return left;
        }
        return dfs2(root.right, root, depth + 1, target);
    }
}
