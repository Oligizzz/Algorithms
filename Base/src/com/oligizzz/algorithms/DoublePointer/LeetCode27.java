package com.oligizzz.algorithms.DoublePointer;

/**
 * @author: chunzhao
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @time: 2022/3/18
 */
public class LeetCode27 {

    public static void main(String[] args) {
        LeetCode27 test = new LeetCode27();
        System.out.println(test.removeElement(new int[]{3, 2, 2, 3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int i = -1;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
