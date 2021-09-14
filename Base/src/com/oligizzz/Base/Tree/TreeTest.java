package com.oligizzz.Base.Tree;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/11
 * @Modify By:
 */
public class TreeTest {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.DEFAULT_TREE;
        System.out.println(tree.lastOrderTraversal_Recursion(tree));
        System.out.println(tree.lastOrderTraversal_Iteration(tree));
        System.out.println(tree.layerOrderTraversal(tree));
    }
}
