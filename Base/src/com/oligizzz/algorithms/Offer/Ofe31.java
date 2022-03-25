package com.oligizzz.algorithms.Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: chunzhao
 * @time: 2022/3/25
 */
public class Ofe31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int a : pushed) {
            stack.push(a);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
