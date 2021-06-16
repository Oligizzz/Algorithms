package com.oligizzz.algorithms.Offer;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/22
 * @Modify By:
 */
public class Offer45 {
    public static void main(String[] args) {
        Offer45 offer45 = new Offer45();
        System.out.println(offer45.minNumber(new int[]{10,2}));
    }
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int a : nums) {
            list.add(new String(String.valueOf(a)));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1+o2;
                String b = o2+o1;
                if(Long.parseLong(a)>Long.parseLong(b)){
                    return 1;
                }else{
                 return -1 ;
                }
            }
        });
        StringBuilder res = new StringBuilder();
        for(String t : list){
            res.append(t);
        }
        return res.toString();
    }
}
