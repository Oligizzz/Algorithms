package com.oligizzz.algorithms.ListNode;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/21
 * @Modify By:
 */
public class ListNodeIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
