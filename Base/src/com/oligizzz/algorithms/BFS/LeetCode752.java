package com.oligizzz.algorithms.BFS;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/25
 * @Modify By:
 */
public class LeetCode752 {

    public static void main(String[] args) {
        String [] test = new String[]{"0201","0101","0102","1212","2002"};
        System.out.println(openLock(test, "0202"));
    }
    public static int openLock(String[] deadends, String target) {
        //把死亡数字存起来
        Set<String> cannot = new HashSet<>(Arrays.asList(deadends));
        //目标值在死亡数字中旧世界返回
        if (cannot.contains(target)) {
            return -1;
        }
        //BFS起点
        String start = "0000";
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                //依次处理队列总的所有单词
                String cur = queue.poll();
                if (canChangeToTarget(cur, cannot, target, visited, queue)) {
                    return step+1;
                }
            }
            //层数加一
            step++;
        }
        return -1;

    }

    private static boolean canChangeToTarget(String cur, Set<String> cannot, String target, Set<String> visited, Queue<String> queue) {
        char[] arr = cur.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char origin = arr[i];
            for(char c : getHelp(origin)){
                arr[i] = c;
                String changed = String.valueOf(arr);
                if(target.equals(changed)){
                    return true;
                }

                if(!visited.contains(changed)){
                    queue.offer(changed);
                    visited.add(changed);
                }
                arr[i] = origin;

            }
        }
        return false;
    }


    private static char [] getHelp(char cur){
        char [] res = new char[2];
        if(cur>'0'&&cur<'9'){
            res[0] = (char)(cur-1);
            res[1] = (char)(cur+1);
        }else if(cur == '0'){
            res[0] = '9';
            res[1] = '1';
        }else{
            res[0] = '8';
            res[1] = '0';
        }
        return res;
    }


}
