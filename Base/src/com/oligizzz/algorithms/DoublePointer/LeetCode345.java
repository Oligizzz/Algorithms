package com.oligizzz.algorithms.DoublePointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: chunzhao
 * @time: 2022/3/18
 */
public class LeetCode345 {
    public static void main(String[] args) {
        LeetCode345 test = new LeetCode345();
        System.out.println(test.reverseVowels("LEETCODE"));
    }

    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (set.contains(arr[i]) && set.contains(arr[j])) {
                char temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            } else {
                if (!set.contains(arr[i])) {
                    i++;
                }
                if (!set.contains(arr[j])) {
                    j--;
                }
            }
        }
        return new String(arr);
    }
}
