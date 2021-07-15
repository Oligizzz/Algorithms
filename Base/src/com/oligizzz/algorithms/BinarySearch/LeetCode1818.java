package com.oligizzz.algorithms.BinarySearch;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description: 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * <p>
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
 * |x| 定义为：
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 * @Date: 2021/7/14
 * @Modify By:
 */
public class LeetCode1818 {
    public static void main(String[] args) {
        int [] a = new int[]{1,10,4,4,2,7};
        int [] b = new int[]{9,3,5,1,7,4};
        LeetCode1818 leetCode1818 = new LeetCode1818();
        System.out.println(leetCode1818.minAbsoluteSumDiff(a, b));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;
        int len = nums1.length;
        // 拷贝一份 nums1
        int[] cop = nums1.clone();
        Arrays.sort(cop);
        // 绝对值和
        long sum = 0;
        int maxDis = 0;
        for (int i = 0; i < len; i++) {
            int a = nums1[i];
            int b = nums2[i];
            if (a == b) {
                continue;
            }
            int curAbs = Math.abs(a - b);
            sum += curAbs;
            // 从nums1中找一个最接近nums2[i]的数来替换nums1[i]
            int lo = 0;
            int hi = len - 1;
            while (lo < hi) {
                int mid = lo + hi +1 >> 1;
                if (cop[mid] <= b) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            int newAbs = Math.abs(cop[lo] - b);
            if (lo + 1 < len) {
                newAbs = Math.min(newAbs, Math.abs(cop[lo + 1] - b));
            }
            if (newAbs < curAbs) {
                maxDis = Math.max(maxDis, curAbs - newAbs);
            }
        }

        return (int) (sum - maxDis) % mod;
    }
}
