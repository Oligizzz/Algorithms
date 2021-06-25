package com.oligizzz.algorithms.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/24
 * @Modify By:
 */
public class LeetCode149 {

    public static void main(String[] args) {
        int [][] a = new int [][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoints(a));
    }
    public static int maxPoints(int[][] points) {
        int count = points.length;
        int res = 0;
        for(int i = 0 ; i < count ; i ++){
            int [] point = points[i];
            int x = point[0];
            int y = point[1];
            Map<Double,Integer> map = new HashMap<>();
            for(int j = 0 ; j < count ; j ++){
                if(j == i){
                    continue;
                }
                int [] temp = points[j];
                int curX = temp[0];
                int curY = temp[1];
                Double K = getK(x,y,curX,curY);
                //System.out.print(K+" ");
                map.put(K,(map.getOrDefault(K,1)+1));
            }
            for(Map.Entry<Double,Integer> entry : map.entrySet()){
                res = Math.max(res,entry.getValue());
            }
            //System.out.println();
        }
        return res;
    }


    private static double getK(int x1 , int y1 , int x2 , int y2){
        if(x2 == x1){ return 0;}
        if(y2 == y1){ return 1;}
        return (y2 - y1)/(x2 - x1);
    }
}
