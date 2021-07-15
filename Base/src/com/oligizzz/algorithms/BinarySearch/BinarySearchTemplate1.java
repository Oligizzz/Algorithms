package com.oligizzz.algorithms.BinarySearch;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/14
 * @Modify By:
 */
public class BinarySearchTemplate1 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        int lo = 0;
        int hi = len - 1;
        while (lo <= hi) {
            // 防止整形溢出
            int mid = lo + (hi - lo >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
