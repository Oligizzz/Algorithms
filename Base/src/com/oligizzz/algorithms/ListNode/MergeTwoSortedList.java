package com.oligizzz.algorithms.ListNode;

import com.oligizzz.algorithms.AAA.ListNode;

/**
 * @Author: GNMD
 * @Description: 合并两个有序链表
 * @Date: 2021/6/28
 * @Modify By:
 */
public class MergeTwoSortedList {

    /**
     * 迭代版本
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


    /**
     * 递归版本
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null?l1 : l2;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }

    }


}
