package com.oligizzz.algorithms.Offer;

import java.util.Deque;
import java.util.LinkedList;


/**
 * @author: chunzhao
 * @time: 2022/3/23
 * <p>
 * <p>
 * 2
 * 4 3
 */
public class Ofe09 {

    Deque<Integer> s1 = new LinkedList<>();
    Deque<Integer> s2 = new LinkedList<>();


    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int head = s2.isEmpty() ? -1 : s2.pop();
            return head;

        }
    }
}
