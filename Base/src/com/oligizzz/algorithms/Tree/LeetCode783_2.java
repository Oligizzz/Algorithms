package com.oligizzz.algorithms.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/13
 * @Modify By:
 */
public class LeetCode783_2 {
    public int minDiffInBST(TreeNode root) {
        int res = Integer.MAX_VALUE;
        List<Integer> nums = new ArrayList<>();
        dfs(root,nums);
        for(int i = 1 ; i <nums.size(); i ++){
            res = Math.min(res,(nums.get(i)-nums.get(i-1)));
        }
        return res;
    }

    private void dfs(TreeNode root,List<Integer> nums){
        if(root == null){ return;}
        dfs(root.left,nums);
        nums.add(root.val);
        dfs(root.right,nums);
    }
}
