package com.oligizzz.summarize.GraphTheory.TopologicalSort;

import java.util.*;

/**
 * @Author: GNMD
 * @Description: 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j)
 * 是图的一条有向边。
 * https://leetcode-cn.com/problems/find-eventual-safe-states/
 * @Date: 2021/8/5
 * @Modify By:
 */
public class RingDetection {
    public static void main(String[] args) {

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int len = graph.length;
        // 构造图
        List<List<Integer>> map = new ArrayList<>();
        int[] inDegree = new int[len];
        for (int i = 0; i < len; i++) {
            map.add(new ArrayList<>());
        }

        // 把原来的有向边反过来
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                map.get(graph[i][j]).add(i);
            }
            // 原来的的出度变成现在的的入度
            inDegree[i] = graph[i].length;
        }

        // 开始拓扑排序
        Queue<Integer> queue = new LinkedList<>();

        // 把入度为零的点都入队
        for (int i = 0; i < len; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            // 每次都处理队首元素
            int head = queue.poll();
            // 删除以该点为起点的所有有向边，并更新相关的入度
            for (int neighboring : map.get(head)) {
                inDegree[neighboring]--;
                if (inDegree[neighboring] == 0) {
                    queue.offer(neighboring);
                }
            }
        }

        // 所有入度为 0 的点都是安全点
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i< len ; i++){
            if(inDegree[i] == 0){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }


}
