package com.oligizzz.algorithms.String;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/9
 * @Modify By:
 */
public class LeetCode290 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        LeetCode290 leetCode290 = new LeetCode290();
        System.out.println(leetCode290.wordPattern(pattern, s));
    }
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] str = s.split(" ");
        if (p.length != str.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Map<String,Character> map1 = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            if (map.get(p[i]) == null) {
                map.put(p[i], str[i]);
            } else {
                if (!map.get(p[i]).equals(str[i])) {
                    return false;
                }
            }
            if (map1.get(str[i]) == null) {
                map1.put(str[i], p[i]);
            } else {
                if (map1.get(str[i])!=p[i]) {
                    return false;
                }
            }

        }
        return true;
    }
}
