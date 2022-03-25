package com.oligizzz.algorithms.DoublePointer;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @author: chunzhao
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 * @time: 2022/3/18
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n == 0){
            return null;
        }
        ListNode fast = head;
        for(int i = 0 ; i < n ;i++){
            fast = fast.next;
        }
        //如果fast为空，表示删除的是头结点
        if (fast == null) return head.next;
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
