package com.oligizzz.algorithms.AAA;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/5
 * @Modify By:
 */
public class ListNode {

    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode creatList(int [] arry){
        ListNode head = new ListNode(arry[0]);
        for(int i = 1 ; i < arry.length ; i++){
            insertNode(new ListNode(arry[i]),head);
        }
        return head;
    }

    public static void insertNode(ListNode p,ListNode head){
        ListNode q = head;
        while(q.next != null){
            q = q.next;
        }

        p.next = null;
        q.next = p;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode{");
        ListNode p = this;
        while(p != null){
            sb.append(p.val+" ,");
            p = p.next;
        }
        sb.append("}");
        return sb.toString();
    }
}
