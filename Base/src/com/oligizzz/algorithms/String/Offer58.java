package com.oligizzz.algorithms.String;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/27
 * @Modify By:
 */
public class Offer58 {
    public static void main(String[] args) {
        Offer58 offer58 = new Offer58();
        ;
        System.out.println(offer58.reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        if(s == null || s.length()==0){
            return null;
        }
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i ++){
            sb.append(s.charAt(i));
            if(s.charAt(i)==' '|| i == s.length()-1){
                stack.push(sb.toString());
                sb = new StringBuilder();
                continue;
            }

        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.peek()+" ");
            stack.pop();
        }
        return res.toString();
    }
}
