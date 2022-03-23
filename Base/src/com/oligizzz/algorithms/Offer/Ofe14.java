package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 */
public class Ofe14 {

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        long result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
            result %= (int) 1e9 + 7;
        }
        return (int) (n * result % (int) 1e9 + 7);
    }
}
