package com.oligizzz.algorithms.Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: chunzhao
 * @time: 2022/3/25
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)
 */
public class Ofe30 {

    Deque<Integer> dataStack, minStack;

    public Ofe30() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (dataStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Ofe30 test = new Ofe30();
        test.push(-2);
        test.push(0);
        test.push(-3);
    }
}
