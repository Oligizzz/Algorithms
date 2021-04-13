package com.oligizzz.algorithms.Backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/12
 * @Modify By:
 */
public class LeetCode93 {
    public static void main(String[] args) {
        System.out.println(new LeetCode93().restoreIpAddresses("25525511135"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int len = s.length();
        if(len < 4 || len > 12){ return res;}
        dfs(s,len,0,0,new ArrayDeque<>(),res);
        return res;
    }

    private void dfs(String str ,int len, int index , int chosen,Deque<String> path,List<String> res){
        //base case
        if(index == len){
            if(chosen == 4){
                res.add(String.join(".",path));
            }
            return;
        }

        if(len -index < (4-chosen) || len - index > (4-chosen)*3){
            return;
        }

        for(int i = 0 ; i < 3 ; i ++){
            if(index+i >= len){
                break;
            }
            int temp = isLegal(str,index,index+i);
            if(temp!=-1){
                path.addLast(temp+"");
                dfs(str,len,index+i+1,chosen+1,path,res);
                path.removeLast();
            }
        }
    }

    private int isLegal(String str,int lo , int hi){
        int len = hi -lo + 1;
        //非法
        if(len>1 && str.charAt(0) == '0'){ return -1;}
        int num = 0;
        for(int i = lo ; i <= hi; i++){
            num = num*10 +str.charAt(i) - '0';
        }

        return num>255?-1:num;
    }
}
