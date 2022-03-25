package com.oligizzz.algorithms.DynamicProgramming;


/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/27
 * @Modify By:
 */
public class Offer46 {
    public static void main(String[] args) {
        Offer46 offer46= new Offer46();
        System.out.println(offer46.translateNum(12258));
    }
    public int translateNum(int _num) {
        String num  = String.valueOf(_num);
        int len = num.length();
        int [] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= len ; i++){
            char cur = num.charAt(i-1);
            char pre = num.charAt(i-2);
            if('0'<=cur&&cur<='5'&&'1'<=pre&&pre<='2'){
                dp[i] = dp[i-1]+dp[i-2];
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[len];

    }

    public int translateNum2(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}
