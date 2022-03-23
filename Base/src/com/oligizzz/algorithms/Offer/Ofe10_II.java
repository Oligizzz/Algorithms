package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe10_II {

    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int mod = (int) 1e9 + 7;
        int a = 1;
        int b = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (a + b) % mod;
            a = b;
            b = res;
        }
        return res;
    }
}
