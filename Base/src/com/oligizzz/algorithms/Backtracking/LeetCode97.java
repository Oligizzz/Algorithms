package com.oligizzz.algorithms.Backtracking;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/25
 * @Modify By:
 */
public class LeetCode97 {
    private boolean res;
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3){ return false;}
        if(len3 == 0){ return  true;}
        dfs(s1,s2,s3,0,0,0, this.res);
        return this.res;
    }


    private void dfs(String s1, String s2, String s3,int index1 , int index2 , int index3,boolean res){
        if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length() ){
            this.res = true;
            return;
        }

        if(this.res){ return;}
        if(index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)){
            dfs(s1,s2,s3,index1+1,index2,index3+1,this.res);
        }
        if(this.res){ return;}
        if(index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)){
            dfs(s1,s2,s3,index1,index2+1,index3+1,this.res);
        }
    }
}
