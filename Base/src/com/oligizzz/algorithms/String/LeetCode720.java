package com.oligizzz.algorithms.String;

import java.util.*;

/**
 * @Author: KXiao
 * @Date: 2022/3/17 23:48
 * @Description:
 */
public class LeetCode720 {
    public static void main(String[] args) {
        String[] test = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LeetCode720 leetCode720 = new LeetCode720();
        System.out.println(leetCode720.longestWord(test));
    }

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (int i = words.length - 1; i >= 1; i--) {
            String cur = words[i];
            if (!check(cur, set)) {
                continue;
            }
            return cur;
        }
        return "";
    }

    private boolean check(String str, Set<String> set) {
        for (int j = str.length() - 1; j >= 1; j--) {
            String sub = str.substring(0, j);
            if (!set.contains(sub)) {
                return false;
            }
        }
        return true;
    }
}
