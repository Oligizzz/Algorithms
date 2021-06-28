package com.oligizzz.algorithms.Tree;

/**
 * @Author: GNMD
 * @Description: 判断B树是不是A的一棵子树
 * @Date: 2021/6/28
 * @Modify By:
 */
public class SubTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //先判断根节点匹不匹配，递归左右判断
        return (A != null && B != null) && (match(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }


    private boolean match(TreeNode A, TreeNode B) {
        // B 树所有的都匹配，就说明是一个匹配的树
        if (B == null) {
            return true;
        }
        // 没有完全匹配
        if (A == null || A.val != B.val) {
            return false;
        }
        return match(A.left, B.left) && match(A.right, B.right);
    }
}
