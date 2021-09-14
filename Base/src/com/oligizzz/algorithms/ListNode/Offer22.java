package com.oligizzz.algorithms.ListNode;

import com.oligizzz.algorithms.AAA.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/2
 * @Modify By:
 */
public class Offer22 {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2};
        ListNode listNode = ListNode.creatList(test);
        ListNode kthFromEnd = Offer22.getKthFromEnd2(listNode, 1);
        while (kthFromEnd != null) {
            System.out.println(kthFromEnd.val);
            kthFromEnd = kthFromEnd.next;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = head;
        while (dummy != null) {
            if (queue.size() < k) {
                queue.offer(dummy);
            } else {
                queue.poll();
                queue.offer(dummy);
            }
            dummy = dummy.next;
        }
        return queue.poll();
    }

    public static ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode fast = head, low = head;
        int step = 0;
        while (fast != null) {
            if (step < k) {
                fast = fast.next;
                step++;
            } else {
                fast = fast.next;
                low = low.next;
            }
        }
        return low;
    }
}
