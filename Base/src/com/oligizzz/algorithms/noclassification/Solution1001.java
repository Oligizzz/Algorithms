package com.oligizzz.algorithms.noclassification;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/1
 * @Modify By:
 */
public class Solution1001 {
    public static void main(String[] args) {
        Solution1001 solution1001 = new Solution1001();
        System.out.println(solution1001.clumsy(10));
    }
    public int clumsy(int N) {
        boolean tag = false;
        int res = 0;
        int count = N / 4;
        int remainder = N % 4;
        if (count < 1) {
            return func2(N, remainder);
        }
        res = func(N);
        int i = N - 4;
        for (; i >= N - remainder; i -= 4) {
            res -= func(i);
        }
        if (remainder > 0) {
            return res - func2(i - 1, remainder);
        }
        return res;

    }

    private int func(int temp) {
        return temp * (temp - 1) / (temp - 2) + (temp - 3);
    }


    private int func2(int start, int remainder) {
        if (remainder == 3) {
            return start * (start - 1) / (start - 2);
        } else if (remainder == 2) {
            return start * (start - 1);
        } else {
            return start;
        }
    }
}
