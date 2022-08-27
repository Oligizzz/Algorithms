package com.oligizzz.algorithms.BinarySearch;

/**
 * @author KongXiao
 * @date 2022-08-21 0:02
 */
public class FindKth {

    public static void main(String[] args) {
    }

    /**
     * 找到两个有序数组第 K 大的数字
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int findKth(int[] nums1, int[] nums2, int k) {
        return solution(nums1, 0, nums2, 0, k);
    }

    private int solution(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + k - 2];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        // 比较第 k/2 个数的大小
        int a = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int b = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (a < b) {
            return solution(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return solution(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }


}
