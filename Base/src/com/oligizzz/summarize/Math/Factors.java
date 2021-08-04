package com.oligizzz.summarize.Math;

/**
 * @Author: GNMD
 * @Description: 求因子数量
 * N的因子个数
 * 条件：给定任意一个一个正整数N
 * 要求：求其因子的个数
 * 首先给出结论：对于任意的整型N，分解质因数得到N= P1^x1 * P2^x2* …… * Pn^xn;
 * 则N的因子个数M为 M=（x1+1） * （x2+1） * …… *（xn+1）;
 * 证明过程：
 * 首先 举个例子吧
 * 24 = 2^3 * 3^1；
 * 其质因子有：为2和3 指数为 3和1
 * 那么对于2 有0 1 2 3四种指数选择，对于3 有0 1两种指数选择
 * 所以 就是4 * 2 = 8 个因子个数
 * 如果还是不懂，那么我们就列举出来吧
 * 2 3
 * 2^0*3^0=1 2^0*3^1=3
 * 2^1*3^0=2 2^1*3^1=6
 * 2^2*3^0=4 2^2*3^1=12
 * 2^3*3^0=8 2^3*3^1=24
 *
 * @Date: 2021/8/1
 * @Modify By:
 */
public class Factors {
    /**
     * 求一个数的因子数量
     * @param num
     * @return
     */
    public int getFactors(int num){
        int res = 1;
        for(int i = 2 ; i * i <= num ; i++){
            // 能够被i整除
            if(num % i == 0){
                int a = 0;
                while(num % i == 0){
                    num /= i;
                    a++;
                }
                res = res*(a+1);
            }
        }
        if(num > 1){
            res*=2;
        }
        return res;

    }
}
