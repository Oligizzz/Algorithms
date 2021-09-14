package com.oligizzz.summarize.GraphTheory.TopologicalSort;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/7
 * @Modify By:
 */
public class LeetCode457 {
    public static void main(String[] args) {
        LeetCode457 test= new LeetCode457();
        System.out.println(test.circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        //建立邻接矩阵
        List<List<Integer>> list = new ArrayList<>();
        //入度信息
        int [] inDegree = new int[n];
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        // 正边
        for(int i = 0; i < n; i++) {
            int end = ((i + nums[i]) % n + n) % n;
            if(nums[i] <= 0 || i == end) {
                continue;
            }
            list.get(i).add(end);
            inDegree[end]++;
        }
        if(help(inDegree,list)){
            return true;
        }

        list.removeAll(list);
        for(int i = 0 ; i < n ; i++){
            list.add(new ArrayList<>());
        }
        Arrays.fill(inDegree,0);

        for(int i = 0 ; i < n ; i++){
            int end = ((i + nums[i]) % n + n) % n;
            if(nums[i] >= 0 || i == end) {
                continue;
            }
            list.get(i).add(end);
            inDegree[end]++;
        }
        return help(inDegree,list);

    }

    /**
     *  拓扑排序
     * @param inDegree 入度信息
     * @param list 邻接表
     * @return 是否成环
     */
    private boolean help(int [] inDegree,List<List<Integer>> list){
        // 开始拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的全部入队
        for(int i = 0 ; i < inDegree.length ; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int head = queue.poll();
            for(int x : list.get(head)){
                inDegree[x]--;
                if(inDegree[x] == 0){
                    queue.offer(x);
                }
            }
        }

        for(int i = 0 ; i < inDegree.length ; i++){
            if(inDegree[i] != 0 ){
                return true;
            }
        }
        return false;
    }
}
