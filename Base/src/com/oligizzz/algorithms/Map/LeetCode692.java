package com.oligizzz.algorithms.Map;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/20
 * @Modify By:
 */
public class LeetCode692 {

    public static void main(String[] args) {
        LeetCode692 leetCode692 = new LeetCode692();
        System.out.println(leetCode692.topKFrequent2(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() == o1.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
            }
        });
        System.out.println(list);

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }


    /**
     * HashMap+Priority
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Object []> p = new PriorityQueue<>(k,new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return ((Integer) o1[1]).equals((Integer) o2[1]) ? ((String)o1[0]).compareTo((String)o2[0]):((Integer) o2[1])-((Integer) o1[1]);
            }
        });

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(p.size()<k){
                p.add(new Object[]{entry.getKey(),entry.getValue()});
            }else{
                Object [] top = p.peek();
                if(entry.getValue()>(Integer) top[1]){
                    p.poll();
                    p.add(new Object[]{entry.getKey(),entry.getValue()});
                }else if(entry.getValue().equals((Integer) top[1])){
                    if(entry.getKey().compareTo((String)top[0])<0){
                        p.poll();
                        p.add(new Object[]{entry.getKey(),entry.getValue()});
                    }
                }
            }
        }

        List<String> res = new ArrayList<>(k);
        while(!p.isEmpty()){
            res.add((String)p.poll()[0]);
        }
        Collections.reverse(res);
        return res;
    }


}
