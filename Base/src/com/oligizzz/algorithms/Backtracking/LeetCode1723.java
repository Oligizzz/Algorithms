package com.oligizzz.algorithms.Backtracking;

/**
 * @Author: GNMD
 * @Description:
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。
 * 请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * 示例 1：
 *
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * @Date: 2021/5/8
 * @Modify By:
 */
public class LeetCode1723 {
    public static void main(String[] args) {
        LeetCode1723 leetCode1723 = new LeetCode1723();
        System.out.println(leetCode1723.minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
    }

    int res = Integer.MAX_VALUE;
    int [] jobs;
    int n;
    int k;
    public int minimumTimeRequired(int[] _jobs, int _k) {
        n = _jobs.length;
        k = _k;
        jobs = _jobs;
        int [] sum = new int[k];
        dfs(0,sum,0,0);
        return res;
    }

    /**
     *
     * @param index 处理到的任务下表
     * @param sum 工人工作时间统计
     * @param max 当前工人的最大工作时间
     */
    private void dfs(int index ,int [] sum , int max ,int used){
        //如果当前工人的最大工作时间超过其他分配方法，可以剪枝返回掉
        if(max >= res){
            return;
        }

        // 处理完所有工作可以统计
        if(index == n){
            res = max;
            return;
        }

        if(used < k){
            sum[used] = jobs[index];
            dfs(index+1,sum,Math.max(max,sum[used]),used+1);
            sum[used] = 0;
        }

        //当前工作可以依次分配给K个工人
        for(int i = 0 ; i < used ; i ++){
            //分配给第 i 个工人
            sum[i] +=jobs[index];
            dfs(index+1,sum,Math.max(max,sum[i]),used);
            //撤销分配
            sum[i] -=jobs[index];
        }
    }
}
