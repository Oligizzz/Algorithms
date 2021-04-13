package com.oligizzz.algorithms.ListNode.ReverseLinked;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/12
 * @Modify By:
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        for(int i = 0 ; i < left -1 ; i ++){
            pre = pre.next;
        }
        ListNode lo = pre.next;
        ListNode hi = pre;
        for(int j = 0 ; j < right - left +1 ; j++){
            hi = hi.next;
        }
        ListNode end = hi.next;
        pre.next = null;
        hi.next = null;
        pre.next = ListNodeReverse(lo);
        lo.next = end;
        return dummy.next;

    }

    private ListNode ListNodeReverse(ListNode head){
        if(head == null || head.next==null){ return head;}
        ListNode res = ListNodeReverse(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}




class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
