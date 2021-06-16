package com.oligizzz.algorithms.Backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/6
 * @Modify By:
 */
public class LeetCode474 {

    public static void main(String[] args) {
        LeetCode474 leetCode474 = new LeetCode474();
        System.out.println(leetCode474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    int res = 0;
    String [] str;
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        str = strs;
        dfs(len,0,new StringBuilder(),0,m,n);
        return res;
    }

    private void dfs(int len ,int index, StringBuilder path, int size,int m , int n){
        if(path.toString().length() > m+n){
            return;
        }

        if(!isLegal(path, m, n)){
            return;
        }

        if(index == len ){
            if(isLegal(path,m,n)){
                System.out.println(path.toString());
                res = Math.max(res,size);
            }
            return;
        }

        //选择加入
        int start = path.length();
        path.append(str[index]);
        int end = path.length();
        size+=1;
        dfs(len ,index+1,path,size,m,n);
        //丢弃
        path.delete(start,end);
        size-=1;
        dfs(len,index+1,path,size,m,n);
    }

    private boolean isLegal(StringBuilder path,int m , int n){
        String str = path.toString();
        int a = 0;
        int b = 0;
        for(int i = 0 ; i < str.length() ; i ++){
            if(str.charAt(i) == '0'){
                a++;
            }else{
                b++;
            }
        }
        return a <= m && b<=n;
    }
}
