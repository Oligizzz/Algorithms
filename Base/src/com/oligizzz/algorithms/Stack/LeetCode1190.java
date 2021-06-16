package com.oligizzz.algorithms.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/26
 * @Modify By:
 */
public class LeetCode1190 {
    public static void main(String[] args) {
        LeetCode1190 leetCode1190 = new LeetCode1190();
        System.out.println(leetCode1190.reverseParentheses("(u(love)i)"));
    }

    public String reverseParentheses(String s) {
        String str = new String();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(str);
                str = "";
            } else if (s.charAt(i) == ')') {
                str = new StringBuilder(str).reverse().toString();
                str = stack.peek() + str;
                stack.pop();
            } else {
                str += s.charAt(i);
            }
        }
        return str;
    }
}
