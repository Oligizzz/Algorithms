package com.oligizzz.algorithms.Offer;

import com.oligizzz.algorithms.AAA.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Ofe06 {

    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        for (int a : stack) {
            res[i++] = a;
        }
        return res;
    }
}
