package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe15 {
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res += n&1;
            n>>>=1;
        }
        return res;
    }
}
