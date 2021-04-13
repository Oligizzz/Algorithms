package com.oligizzz.algorithms.Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: GNMD
 * @Description:
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

 * 示例 1：

 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：

 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"。
 * @Date: 2021/4/12
 * @Modify By:
 */
public class LeetCode179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String [] temp = new String[len];
        for(int i = 0 ; i < len ; i++){
            temp[i] = "" +nums[i];
        }

        Arrays.sort(temp, (o1, o2) -> {
            String a = o1+o2;
            String b = o2+o1;
            return b.compareTo(a);
        });

        StringBuilder res = new StringBuilder();
        for(String a : temp){ res.append(a);}
        int index = 0;
        while(index<len -1 && res.charAt(index) == '0'){
            index++;
        }
        return res.substring(index);
    }
}
