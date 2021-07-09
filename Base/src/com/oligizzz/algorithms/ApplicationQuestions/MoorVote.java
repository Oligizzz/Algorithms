package com.oligizzz.algorithms.ApplicationQuestions;

/**
 * @Author: GNMD
 * @Description: 摩尔投票问题
 * 数组中占比超过一半的元素称之为主要元素。
 * 给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * @Date: 2021/7/9
 * @Modify By:
 */
public class MoorVote {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        //候选人
        int candidate = -1;
        // 计数器
        int count =0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }

            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }
        //到这里之后能说明candidate是数量较多的元素，还不能判断他是不是已经超过一半
        //验证候选人
        count = 0;
        for(int num : nums){
            if(num == candidate){
                count++;
            }
        }

        return count>len/2?candidate:-1;
    }
}
