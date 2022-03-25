package com.oligizzz.algorithms.DoublePointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: KXiao
 * @time: 2022/3/18
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 */
public class LeetCode3 {

    public static void main(String[] args) {
        LeetCode3 test= new LeetCode3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i))+1);
            }
            res = Math.max(res,i-left+1);
            map.put(s.charAt(i),i);
        }
        return res;
    }
}
