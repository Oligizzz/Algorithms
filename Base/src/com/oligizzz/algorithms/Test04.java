package com.oligizzz.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/12
 * @Modify By:
 */
public class Test04 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,1,2,5,5,2,8,8,7,9,9,7,10}));
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
