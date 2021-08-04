package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: GNMD
 * @Description: 最短路径问题
 * 有 n 个网络节点，标记为 1 到 n。
 * <
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * https://leetcode-cn.com/problems/network-delay-time/
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * @Date: 2021/8/2
 * @Modify By:
 */
public class LeetCode743 {
    private static final int MAX_DIS = Integer.MAX_VALUE;

    public static void main(String[] args) {
        LeetCode743 test = new LeetCode743();
        System.out.println(test.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //先建立邻接矩阵
        int[][] map = new int[101][101];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = i == j ? 0 : MAX_DIS;
            }
        }

        for (int[] node : times) {
            map[node[0]][node[1]] = node[2];
        }
        return dijkstra(map, k, n);
    }

    /**
     * 迪杰斯特拉（dijkstra）算法
     *
     * @param map   有向图
     * @param start 起点
     * @param end   终点
     * @return 最短距离
     */
    private int dijkstra(int[][] map, int start, int end) {
        // 节点个数
        int n = map.length;
        // 最短距离
        int dis = -1;
        // visited数组
        boolean[] used = new boolean[n];
        // 起点到各点的距离表
        int[] distance = new int[n];
        // 最短距前驱节点
        int[] parent = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            used[i] = false;
            // 起点到各点的距离
            distance[i] = map[start][i];
            parent[i] = -1;
            if (distance[i] != MAX_DIS) {
                parent[i] = start;
            }
        }
        Arrays.fill(used, false);
        Arrays.fill(distance, MAX_DIS);

        used[start] = true;
        distance[start] = 0;

        for (int i = 0; i < n; i++) {
            int min = MAX_DIS;
            int k = 0;
            // 先找到距离起点最短的点
            for (int j = 0; j < n; j++) {
                if (!used[j] && distance[j] < min) {
                    min = distance[j];
                    k = j;
                }
            }

            // 加入已选顶点集合
            used[k] = true;

            // 更新两个表
            for (int l = 0; l < n; l++) {
                if (!used[l] && map[k][l] != MAX_DIS) {
                    // start 到 l 的距离 大于start到k + k到l的距离
                    if (distance[l] > distance[k] + map[k][l]) {
                        distance[l] = distance[k] + map[k][l];
                        parent[l] = k;
                    }
                }

                if (k == end) {
                    break;
                }
            }
        }

        dis = distance[end];
        return dis == MAX_DIS ? -1 : dis;
    }
}
