package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/25
 * @Modify By:
 */
public class LeetCode1743 {

    public static void main(String[] args) {
        int [] res = LeetCode1743.restoreArray(new int[][]{{2,1},{3,4},{3,2}});
        System.out.println(Arrays.toString(res));
    }
    public static int[] restoreArray(int[][] adjacentPairs) {
        int len = adjacentPairs.length;;
        if(len == 1){
            return adjacentPairs[0];
        }
        Map<Integer, List<Integer> > temp = new HashMap<>();
        for(int j = 0 ; j < adjacentPairs.length ; j++){
            int [] a = adjacentPairs[j];
            int num1 = a [0];
            int num2 = a[1];
            List<Integer> neighbour1 = temp.getOrDefault(num1,new ArrayList<>());
            neighbour1.add(num2);
            List<Integer> neighbour2 = temp.getOrDefault(num2,new ArrayList<>());
            neighbour2.add(num1);
            temp.put(num1,neighbour1);
            temp.put(num2,neighbour2);
        }
        int [] res = new int[len+1];
        boolean [] used = new boolean[len];

        for(Map.Entry<Integer,List<Integer>> entry : temp.entrySet()){
            if(entry.getValue().size()==1){
                res[0] = entry.getKey();
                res[1] = entry.getValue().get(0);
                break;
            }
        }
        for(int i = 1 ; i < len ; i++){
            int cur = res [i];
            List<Integer> t = temp.get(cur);
            int a = t.get(0);
            res[i+1] = a == res[i-1]?t.get(1):a;
        }
        return res;

    }
}
