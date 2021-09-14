package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: GNMD
 * @Description: 二叉树的层序遍历
 * @Date: 2021/4/25
 * @Modify By:
 */
public class LevelOrderOfBinaryTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){ return res;}
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            for(int i = 1 ; i <= count ; i++){
                TreeNode cur = queue.poll();
                temp.add(cur.val);

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
