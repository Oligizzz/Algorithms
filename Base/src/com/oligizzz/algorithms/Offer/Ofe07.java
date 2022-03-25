package com.oligizzz.algorithms.Offer;

import com.oligizzz.Base.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: chunzhao
 * @time: 2022/3/23
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 */
public class Ofe07 {

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] _preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        preorder = _preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return builder(0, 0, inorder.length);
    }

    /**
     * @param root  先序遍历 根节点下标
     * @param left  中序遍历区间
     * @param right 中序遍历区间
     * @return 根节点
     */
    private TreeNode builder(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode res = new TreeNode(preorder[root]);
        int index = map.get(preorder[root]);
        res.left = builder(root + 1, left, index - 1);
        res.right = builder(root + index - left + 1, index + 1, right);
        return res;
    }
}
