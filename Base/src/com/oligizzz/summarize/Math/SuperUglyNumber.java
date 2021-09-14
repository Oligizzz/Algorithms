package com.oligizzz.summarize.Math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/9
 * @Modify By:
 */
public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber test = new SuperUglyNumber();
        System.out.println(test.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));

    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }

        Set<Long> help = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        help.add(1L);
        heap.offer(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = heap.poll();
            res = (int) cur;
            for (int p : primes) {
                long temp = cur * p;
                if (help.add(temp)) {
                    heap.offer(temp);
                }
            }
        }
        return res;
    }
}
