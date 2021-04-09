package com.oligizzz.algorithms.Search;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/7
 * @Modify By:
 */
public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        SearchRotatedSortedArray s = new SearchRotatedSortedArray();
        System.out.println(s.search(new int[]{1,0,1,1,1}, 5));
    }

    public boolean search(int[] nums, int target) {
        int len = nums.length;
        if (nums == null || len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }

        int lo = 0;
        int hi = len - 1;

        while (lo < hi && nums[0] == nums[hi]) {
            hi--;
        }

        int end = hi;
        // 找到旋转点
        while (lo < hi) {
            int mid = lo + hi + 1 >> 1;
            if (nums[mid] >= nums[0]) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        //分别调用两次二分查找
        boolean res = binarySearchInFixedInterval(nums, 0, hi, target);
        if (res != false) {
            return res;
        }
        return binarySearchInFixedInterval(nums, hi + 1, end, target);

    }

    private boolean binarySearchInFixedInterval(
            int[] nums, int lo, int hi, int target) {

        while (lo <= hi) {
            int mid = lo + (hi - lo >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

}
