package com.oligizzz.algorithms.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: GNMD
 * @Description: 逆波兰式
 * @Date: 2021/4/1
 * @Modify By:
 */
public class ReversePolish {
    public static void main(String[] args) {
        String [] test = new String[]{"4","13","5","/","+"};
        ReversePolish reversePolish = new ReversePolish();
        System.out.println(reversePolish.evalRPN(test));
    }

    public int evalRPN(String[] tokens) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        int len = tokens.length;

        for (int i = 0; i < len; i++) {
            String cur = tokens[i];
            if (isNumber(cur)) {
                stack.push(Integer.parseInt(cur));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (cur) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;
                    case "/":
                        stack.push(a/b);
                        break;
                    default:
                }
            }
        }
        res = stack.pop();
        return res;
    }

    private boolean isNumber(String token){
        return !("+".equals(token)||"-".equals(token)||"*".equals(token)||"/".equals(token));
    }
}
