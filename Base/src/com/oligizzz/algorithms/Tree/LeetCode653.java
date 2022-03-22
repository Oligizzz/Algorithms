package com.oligizzz.algorithms.Tree;

import java.util.*;

/**
 * @author: chunzhao
 * @time: 2022/3/21
 */
public class LeetCode653 {

    public static void main(String[] args) {

    }

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> smaller = new LinkedList<>(), larger = new LinkedList<>();
        TreeNode temp = root;
        while (temp != null) {
            smaller.offerLast(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            larger.offerLast(temp);
            temp = temp.right;
        }
        TreeNode lo = smaller.peekFirst(), hi = larger.peekLast();
        while (lo.val < hi.val) {
            int cur = lo.val + hi.val;
            if (cur == k) {
                return true;
            } else if (cur < k) {
                lo = getNext(smaller, true);
            } else {
                hi = getNext(larger, false);
            }
        }
        return false;
    }

    private TreeNode getNext(Deque<TreeNode> deque, boolean b) {
        TreeNode node = b ? deque.pollLast() : deque.pollFirst();
        TreeNode temp = node;
        while (temp != null) {
            deque.offerLast(temp);
            temp = b?temp.left:temp.right;
        }
        return temp;
    }


    private boolean dfs(TreeNode root, Set<Integer> set, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return dfs(root.left, set, target) || dfs(root.right, set, target);
    }


}
