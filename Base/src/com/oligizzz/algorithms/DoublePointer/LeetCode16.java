package com.oligizzz.algorithms.DoublePointer;

import java.util.Arrays;

/**
 * @author: chunzhao
 * @time: 2022/3/18
 * <p>
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode16 {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else if (sum > target) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
