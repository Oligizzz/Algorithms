package com.oligizzz.algorithms.ListNode;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/5
 * @Modify By:
 */
public class SplitListNode {

    public static void main(String[] args) {
        ListNode head = ListNode.creatList(new int[]{1,4,3,2,5,2});
        SplitListNode test = new SplitListNode();
        System.out.println(head);
        test.partition(head,3);
        System.out.println(head);
    }

    public ListNode partition(ListNode head, int x) {

        ListNode small = new ListNode(0,null);
        ListNode large = new ListNode(0,null);
        ListNode smallHead = small;
        ListNode largeHead = large;

        while(head != null){
            if(head.val < x){
                small.next = head;
                small = small.next;
            }else{
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
