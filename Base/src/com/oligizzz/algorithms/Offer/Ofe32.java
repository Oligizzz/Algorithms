package com.oligizzz.algorithms.Offer;

import com.oligizzz.Base.Tree.TreeNode;

import java.util.*;

/**
 * @author: chunzhao
 * @time: 2022/3/25
 */
public class Ofe32 {

    public static void main(String[] args) {
        Ofe32 test = new Ofe32();
        System.out.println(Arrays.toString(test.levelOrder(TreeNode.DEFAULT_TREE)));
    }

    public int[] levelOrder(TreeNode root) {
        List<Integer> temp = solution(root);
        int[] res = new int[temp.size()];
        int i = 0;
        for (int a : temp) {
            res[i++] = a;
        }
        return res;
    }


    private List<Integer> solution(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                res.add(cur.val);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;

    }
}
