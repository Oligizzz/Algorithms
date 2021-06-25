package com.oligizzz.algorithms.ListNode;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/24
 * @Modify By:
 */
public class SortLinkedList {

    /**
     * 排序链表
     *
     * @param head
     * @return
     */
    public ListNode sort(ListNode head) {
        //递归出口
        if (head == null || head.next == null) {
            return head;
        }
        //找到中点分治
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //保存右边节点
        ListNode temp = slow.next;
        //断开
        slow.next = null;
        //分支排序左右两边
        ListNode left = sort(head);
        ListNode right = sort(temp);

        //开始归并
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummy.next = left;
                left = left.next;
            } else {
                dummy.next = right;
                right = right.next;
            }
            dummy = dummy.next;
        }
        // 处理较长的链表
        dummy.next = left != null ? left : right;
        return res.next;
    }

}
