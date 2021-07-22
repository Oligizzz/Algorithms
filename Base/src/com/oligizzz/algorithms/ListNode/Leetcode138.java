package com.oligizzz.algorithms.ListNode;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/22
 * @Modify By:
 */
public class Leetcode138 {
    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }



    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        // 构造新旧链表的映射关系
        while(head != null){
            // 新节点
            Node newNode = new Node(head.val);
            newNode.next = head.next;
            head.next = newNode;
            head = newNode.next;
        }

        // 从头开始处理random域
        head = dummy.next;
        while(head != null){
            if(head.random != null){
                // 新结点的random域指向元凯节点的random域的新结点
                head.next.random = head.random.next;
            }else{
                head.next.random = null;
            }
            head = head.next.next;
        }

        // 把旧的链表拆掉
        head = dummy.next;
        Node res = head.next;
        while(head != null){
            // 取到新链表的节点
            Node curNew = head.next;
            // 断开新旧链表
            head.next = curNew.next;
            // 处理新链表节点的next域
            if(curNew.next != null){
                curNew.next = curNew.next.next;
            }
            head = head.next;
        }

        return res;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
