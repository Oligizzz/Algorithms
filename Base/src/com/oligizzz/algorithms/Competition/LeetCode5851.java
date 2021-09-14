package com.oligizzz.algorithms.Competition;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/8/22
 * @Modify By:
 */
public class LeetCode5851 {
    public static void main(String[] args) {
        System.out.println(LeetCode5851.findDifferentBinaryString(new String[]{"111","011","001"}));
    }
    public static String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        Set<Integer> temp = new HashSet<>();
        int index = 0;
        String res = "";
        for(String s : nums){
            int cur = Integer.parseInt(s,2);
            temp.add(cur);
        }
        for(int i = 0 ; i < 1<<len;i++){
            if(!temp.contains(i)){
                res=Integer.toBinaryString(i);
                break;
            }
        }
        int l = len-res.length();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < l ; i++){
            stringBuilder.append("0");
        }
        return stringBuilder.append(res).toString();
    }
}
