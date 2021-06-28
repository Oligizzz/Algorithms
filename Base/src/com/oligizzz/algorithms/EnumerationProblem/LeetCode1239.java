package com.oligizzz.algorithms.EnumerationProblem;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: GNMD
 * @Description: 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * 请返回所有可行解 s 中最长长度。
 * @Date: 2021/6/19
 * @Modify By:
 */
public class LeetCode1239 {
    StringBuilder sb=new StringBuilder();
    int res=0;
    public int maxLength(List<String> arr) {
        dfs(arr,0);
        return res;
    }

    public void dfs(List<String> arr,int start){
        char[] ch=sb.toString().toCharArray();
        Set<Character> set=new HashSet<>();
        for(char c:ch){
            if(set.contains(c)){
                return;
            }else{
                set.add(c);
            }
        }
        res=Math.max(res,sb.length());
        for(int i=start;i<arr.size();i++){
            sb.append(arr.get(i));
            dfs(arr,i+1);
            sb.delete(sb.length()-arr.get(i).length(),sb.length());
        }
    }
}
