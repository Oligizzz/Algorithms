package com.oligizzz.summarize.LRU;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/14
 * @Modify By:
 */
public class LRUCache_LinkedList {
    private int capacity;
    private Map<Integer,ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache_LinkedList(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1,-1);
        this.tail = new ListNode(-1,-1);
        head.next = tail;
        tail.pre = head;
    }


    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }

        ListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        moveToTail(node);
        return node.value;
    }

    public void put(int key,int value){
        if(get(key)!= -1){
            map.get(key).value = value;
            return;
        }
        ListNode node = new ListNode(key,value);
        map.put(key,node);
        moveToTail(node);

        if(map.size() > capacity){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }

    }

    public void moveToTail(ListNode node){
        node.pre = tail.pre;
        node.next = tail;
        node.pre.next = node;
        tail.pre = node;
    }

    private class ListNode{
        int key;
        int value;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
}
