package com.oligizzz.algorithms.BinarySearch;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/14
 * @Modify By:
 */
public class BinarySearchTemplate2 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len < 1) {
            return -1;
        }
        int lo = 0;
        int hi = len - 1;
        while (lo < hi) {
            int mid = lo - (hi - lo >> 1);
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        // 根据提议变换判断条件
        return nums[lo] == target ? lo : -1;
    }
}
