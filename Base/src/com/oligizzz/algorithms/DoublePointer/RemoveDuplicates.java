package com.oligizzz.algorithms.DoublePointer;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/6
 * @Modify By:
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        int slow = 2 , fast = 2;

        while(fast < n ){
            if(nums[fast] != nums[slow-2]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow-1;
    }

    /**
     * 删除nums数组中的重复元素，每一个元素最多可以出现K次
     * @param nums 原数组
     * @param k 最多出现次数
     * @return 处理完毕后的数组长度
     */
    public int removeDuplicates2(int [] nums , int k){
        return removeDuplicatesAllowK(nums,k);
    }

    private int removeDuplicatesAllowK(int[] nums, int k) {
        int index = 0;
        for(int a :nums){
            if(index < k || nums[index - k] != a){
                nums[index++] = a;
            }
        }
        return index;
    }
}
