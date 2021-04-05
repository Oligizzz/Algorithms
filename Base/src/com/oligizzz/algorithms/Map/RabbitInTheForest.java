package com.oligizzz.algorithms.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/4
 * @Modify By:
 */
public class RabbitInTheForest {
    public static void main(String[] args) {
        RabbitInTheForest rabbitInTheForest = new RabbitInTheForest();
        System.out.println(rabbitInTheForest.numRabbits(new int[]{1, 1, 2}));
    }
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();

//        for(int a : answers){
//            if(map.get(a)!= null){
//                int t = map.get(a);
//                map.put(a,t+1);
//            }else{
//                map.put(a,1);
//            }
//        }

        for(int a : answers){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getKey();
            int n = entry.getValue();
            if(n % (val +1) == 0){
                res += n / (val+1) * (val+1);
            }else{
                res += (n / (val + 1) +1) * (val +1) ;
            }
        }
        return res;
    }
}
