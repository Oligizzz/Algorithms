package com.oligizzz.algorithms.Map;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/3
 * @Modify By:
 */
public class LeetCode451 {
    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }
    public static String frequencySort(String s) {
        if(s == null || s.length() < 2 ){ return s;}
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length();i++ ){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        StringBuilder res = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : list){
            int count = entry.getValue();
            char cur = entry.getKey();
            for(int j = 0 ; j < count ; j++){
                res.append(cur);
            }
        }
        return res.toString();
    }
}
