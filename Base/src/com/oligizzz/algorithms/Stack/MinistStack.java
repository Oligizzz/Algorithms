package com.oligizzz.algorithms.Stack;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/9
 * @Modify By:
 */
public class MinStack {
    private static class Node<Integer> {
        Integer val;
        Node next;

        Node() {
        }
        Node(Integer val, Node next) {
            this.val = val;
            this.next = next;
        }
        boolean end(){ return val == null && next == null;}
    }

    private Node top = new Node();
    private Node min = top;

    /** initialize your data structure here. */
    MinStack() {

    }


    public void push(int val) {
        Node temp = top;
        top = new Node(val , top);
        if((Integer)top.val <(Integer)temp.val){
            min = top;
        }
    }

    public void pop() {
        if(!top.end()){
            top = top.next;
        }
    }

    public int top() {
        return (int) top.val;
    }

    public int getMin() {
        return (int) min.val;
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
