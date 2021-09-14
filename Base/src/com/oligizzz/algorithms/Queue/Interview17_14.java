package com.oligizzz.algorithms.Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/3
 * @Modify By:
 */
public class Interview17_14 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Interview17_14.smallestK2(new int[]{1, 6, 3, 5, 4, 2}, 3)));
    }

    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int a : arr) {
            queue.offer(a);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static int[] smallestK2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int[] res = new int[k];
        if (k == 0) {
            return res;
        }

        for (int a : arr) {
            if (queue.size() == k && a >= queue.peek()) {
                continue;
            }
            if(queue.size() == k){queue.poll();}
            queue.offer(a);
        }
        for(int i = k-1 ; i >= 0 ; i--){
            res[i] = queue.poll();
        }
        return res;
    }
}
