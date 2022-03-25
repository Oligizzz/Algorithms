package com.oligizzz.algorithms.Offer;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode p = head;
        ListNode temp = null;
        while (p != null) {
            temp = p.next;
            p.next = res.next;
            res.next = p;
            p = temp;
        }
        return res.next;
    }
}
