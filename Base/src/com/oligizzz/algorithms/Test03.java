package com.oligizzz.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/10
 * @Modify By:
 */
public class Test03 {
    public static void main(String[] args) {
        System.out.println(test(3));
    }
    private static List<Integer> test (int n){
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i) {
            ret.add(i ^ i>>1);
            System.out.println(i ^ i>>1);
        }
        return ret;
    }
}
