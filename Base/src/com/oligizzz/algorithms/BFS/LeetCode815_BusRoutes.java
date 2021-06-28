package com.oligizzz.algorithms.BFS;

import java.util.*;

/**
 * @Author: GNMD
 * @Description: 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * <p>
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * <p>
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 * @Date: 2021/6/28
 * @Modify By:
 */
public class LeetCode815_BusRoutes {


    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //建立路线之间的无向图，如果两条路线之间有一个公共的车站就说明两条路线之间有一条边
        //路线条数
        int n = routes.length;
        boolean[][] map = new boolean[n][n];
        //记录每一个车站属于哪些线路
        Map<Integer, List<Integer>> station_routes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int station : routes[i]) {
                //当前站点有哪些线路经过
                List<Integer> list = station_routes.getOrDefault(station, new ArrayList<Integer>());
                //经过当前站点的路线之间都有边
                for (int j : list) {
                    map[i][j] = map[j][i] = true;
                }
                list.add(i);
                station_routes.put(station,list);
            }
        }

        //利用BFS求两点之间的最短路径
        int [] dis = new int[n];
        Arrays.fill(dis,-1);
        Queue<Integer> queue = new LinkedList<>();
        //先把包含起点的路线都入队
        for(int rou : station_routes.getOrDefault(source,new ArrayList<>())){
            dis[rou] = 1;
            queue.offer(rou);
        }
        while(!queue.isEmpty()){
            int curRou = queue.poll();
            for(int nextRout = 0 ; nextRout<n ;nextRout++){
                if(map[curRou][nextRout] && dis[nextRout] == -1){
                    dis[nextRout] = dis[curRou]+1;
                    queue.offer(nextRout);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int r : station_routes.getOrDefault(target,new ArrayList<>())){
            if(dis[r]!=-1){
                res = Math.min(res,dis[r]);
            }
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}
