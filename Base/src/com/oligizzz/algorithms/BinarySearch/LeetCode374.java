package com.oligizzz.algorithms.BinarySearch;

/**
 * @Author: GNMD
 * @Description: 猜数字游戏的规则如下：
 * <p>
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 * <p>
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 * @Date: 2021/6/14
 * @Modify By:
 */
public class LeetCode374 {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return 0;
    }
}
