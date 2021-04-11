package com.oligizzz.algorithms.DynamicProgramming;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/11
 * @Modify By:
 */
public class LeetCode91 {
    public int numDecodings(String s) {
        int len = s.length();
        int [] dp = new int[len];
        char [] ch = s.toCharArray();
        if(ch[0] == '0'){ return  0;}
        dp[0] = 1;


        for(int i = 1 ; i < len ; i++){
            if(ch[i] != '0'){
                dp[i] = dp[i-1];
            }

            int temp = 10*(ch[i-1]-'0')+(ch[i]-'0');
            if(temp>=10 && temp <= 26){
                if(i == 1){
                    dp[i]++;
                }else{
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[len-1];
    }


    public int numDecodings2(String s){
        char [] ch = s.toCharArray();
        if(ch[0] == '0'){ return 0;}
        int dp = 1 , cur = 1;
        for(int i = 1 ; i < ch.length ; i ++){
            int temp = cur;
            if(ch[i]=='0'){
                if(ch[i-1]=='1' ||ch[i-1] == '2'){
                    cur = dp;
                }else{
                    return 0;
                }
            }else{
                if(ch[i-1]=='1' ||ch[i-1] == '2' && ch[i]>='1' && ch[i]<='6'){
                    cur = cur + dp;
                }
            }
            dp = temp;
        }
        return cur;
    }
}
