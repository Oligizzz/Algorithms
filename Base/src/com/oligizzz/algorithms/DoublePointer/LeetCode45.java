package com.oligizzz.algorithms.DoublePointer;

/**
 * @author: chunzhao
 * <p>
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * </p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * </p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * [2,4,3,4,8]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * </p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @time: 2022/3/18
 */
public class LeetCode45 {
    public static void main(String[] args) {
        LeetCode45 test = new LeetCode45();
        System.out.println(test.jump(new int[]{2, 3, 1, 1, 4}));
    }

    public int jump(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int right = nums.length - 1;
        while (right > 0) {
            for (int i = 0; i < right; i++) {
                if (nums[i] >= right) {
                    res++;
                    right = i;
                    break;
                }
            }
        }
        return res;
    }
}
