package com.oligizzz.Base.Tree;

import java.util.*;

/**
 * @Author: Oligizzz
 * @Description: 基本二叉树
 * @Date: 2021/9/11
 * @Modify By:
 */
public class TreeNode {

    /**
     * 数据域
     */
    public int val;
    /**
     * 左孩子
     */
    public TreeNode left;
    /**
     * 右孩子
     */
    public TreeNode right;

    /**
     * DEFAULT_TREE:
     *
     *      3
     *     / \
     *    9   20
     *       /  \
     *      15    7
     */
    public static final TreeNode DEFAULT_TREE;
    /**
     * 默认属的先序序列
     */
    private static final int[] PREORDER = {3, 9, 20, 15, 7};
    /**
     * 默认树的中序序列
     */
    private static final int[] INORDER = {9, 3, 15, 20, 7};

    static {
        DEFAULT_TREE = buildDefaultTree(PREORDER, INORDER);
    }

    /**
     * 无参构造
     */
    public TreeNode() {
    }


    /**
     * 带参构造
     *
     * @param val 数据域
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 有参构造
     *
     * @param val   数据域
     * @param left  左孩子
     * @param right 右孩子
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**================================================*/
    /** ------------------ 相关算法---------------------*/
    /**================================================*/

    /**
     * 先序遍历--递归版本
     *
     * @param root 根节点
     * @return 遍历序列
     */
    public List<Integer> preorderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }


    /**
     * 先序遍历--迭代版本
     *
     * @param root 根节点
     */
    public List<Integer> preorderTraversal_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 辅助栈
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;

    }

    /**
     * 二叉树的中序遍历--递归实现
     *
     * @param root 根节点
     * @return 中序序列
     */
    public List<Integer> inOrderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrderTraversal(root, res);
        return res;
    }

    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }


    /**
     * 二叉树的中序遍历--迭代版本
     *
     * @param root 根节点
     * @return 中序序列
     */
    public List<Integer> inOrderTraversal_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 辅助栈
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }


    /**
     * 二叉树后序遍历
     *
     * @param root 根节点
     * @return 后序序列
     */
    public List<Integer> lastOrderTraversal_Recursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        lastOrderTraversal(root, res);
        return res;
    }

    public void lastOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        lastOrderTraversal(root.left, list);
        lastOrderTraversal(root.right, list);
        list.add(root.val);
    }

    /**
     * 二叉树的后序遍历
     *
     * @param root 根节点
     * @return 后序序列
     */
    public List<Integer> lastOrderTraversal_Iteration(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.right == null || node.right == pre) {
                res.add(node.val);
                pre = node;
                node = null;
            } else {
                stack.push(node);
                node = node.right;
            }
        }
        return res;
    }


    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List<List<Integer>> layerOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        TreeNode node = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            int curLevelCount = queue.size();
            for(int i = 0 ; i < curLevelCount ; i++){
                TreeNode sameLevelNode = queue.poll();
                temp.add(sameLevelNode.val);
                if(sameLevelNode.left != null){
                    queue.offer(sameLevelNode.left);
                }

                if(sameLevelNode.right != null){
                    queue.offer(sameLevelNode.right);
                }
            }
            res.add(new ArrayList<>(temp));
            temp.clear();
        }
        return res;
    }


    /**
     * 根据先序遍历和后续遍历构造一棵二叉树
     *
     * @param preorder 先序遍历
     * @param inorder  中序遍历
     * @return
     */
    public static TreeNode buildDefaultTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1, preorder, map);

    }

    static TreeNode recur(int root, int left, int right, int[] preorder, Map<Integer, Integer> map) {
        // 递归终止
        if (left > right) {
            return null;
        }
        // 建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        // 划分根节点、左子树、右子树
        int i = map.get(preorder[root]);
        // 开启左子树递归
        node.left = recur(root + 1, left, i - 1, preorder, map);
        // 开启右子树递归
        node.right = recur(root + i - left + 1, i + 1, right, preorder, map);
        return node;
    }


}
