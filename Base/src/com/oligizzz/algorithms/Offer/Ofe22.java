package com.oligizzz.algorithms.Offer;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @author: chunzhao
 * @time: 2022/3/24
 */
public class Ofe22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
