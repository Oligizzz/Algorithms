package com.oligizzz.algorithms.Offer;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = head;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                break;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return head;
    }
}
