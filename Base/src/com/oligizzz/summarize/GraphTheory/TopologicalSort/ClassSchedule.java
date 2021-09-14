package com.oligizzz.summarize.GraphTheory.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/5
 * @Modify By:
 */
public class ClassSchedule {
    public static void main(String[] args) {
        ClassSchedule test = new ClassSchedule();
        System.out.println(test.canFinish(2, new int[][]{{1,0},{0,1}}));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //邻接表存储
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adjacencyList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int head = queue.poll();
            for (int neib : adjacencyList.get(head)) {
                inDegree[neib]--;
                if (inDegree[neib] == 0) {
                    queue.offer(neib);
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;

    }
}
