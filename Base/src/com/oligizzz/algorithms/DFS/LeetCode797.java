package com.oligizzz.algorithms.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/26
 * @Modify By:
 */
public class LeetCode797 {
    int N;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    int [][] map;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        N = graph.length;
        map = graph;
        path.add(0);
        dfs(0);
        return res;
    }


    private void dfs(int index){
        if(index == N - 1){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int next : map[index]){
            path.add(next);
            dfs(next);
            path.remove(path.size()-1);
        }
    }
}
