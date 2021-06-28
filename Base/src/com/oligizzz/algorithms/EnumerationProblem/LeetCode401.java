package com.oligizzz.algorithms.EnumerationProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/21
 * @Modify By:
 */
public class LeetCode401 {

    public static void main(String[] args) {
        LeetCode401 l = new LeetCode401();
        System.out.println(l.readBinaryWatch(1));
    }

    int [] hour = new int[]{0,1,2,4,8};
    int [] min = new int[]{0,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        if(turnedOn == 0 || turnedOn >8){ return res;}
        dfs(0,0,0,0,turnedOn,res);
        return res;
    }

    private void dfs(int curH , int curM , int a , int b , int turnedOn,List<String> res){

        if(curH>12 || curM > 59){
            return;
        }

        if(a > 3 || b > 5 ){
            return;
        }

        if(a+b == turnedOn){
            String M = curM<10?("0"+curM):""+curM;
            String temp = curH + ":"+M;
            res.add(temp);
            return;
        }
        dfs(curH+hour[a+1],curM,a+1,b,turnedOn,res);
        dfs(curH,curM+min[b+1],a,b+1,turnedOn,res);

    }
}
