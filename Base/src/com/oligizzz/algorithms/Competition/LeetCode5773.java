package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/30
 * @Modify By:
 */
public class LeetCode5773 {
    public static void main(String[] args) {
        LeetCode5773 leetCode5773 = new LeetCode5773();
        System.out.println(leetCode5773.maxValue("55552223", 4));

    }

    public String maxValue(String n, int x) {
        char c = n.charAt(0);
        if(c== '-'){
            return "-"+solution2(n.substring(1),x);
        }else{
            return solution1(n,x);
        }

    }

    private String solution1(String s, int x) {
        if(s==null || s.length() ==0){ return "0";}
        StringBuilder res = new StringBuilder(s);
        int index = 0;
        char cur = s.charAt(index);
        while (cur == '0') {
            index++;
        }
        if (index > s.length() - 1) {
            return String.valueOf(x);
        }
        //如果当前字符比插入字符小
        if (String.valueOf(cur).compareTo(String.valueOf(x)) < 0) {
            return new StringBuilder().append(x).append(s).toString();
        }
        while ((String.valueOf(cur).compareTo(String.valueOf(x)) < 0)&&index<s.length()-1) {
            index++;
            cur = s.charAt(index);
        }
        res.insert(index,x);
        return res.toString();
    }

    private String solution2(String s, int x) {
        if(s==null || s.length() ==0){ return "0";}
        StringBuilder res = new StringBuilder(s);
        int index = 0;
        char cur = s.charAt(index);
        while (cur == '0') {
            index++;
        }
        if (index > s.length() - 1) {
            return String.valueOf(x);
        }
        //如果当前字符比插入字符小
        if ((String.valueOf(cur).compareTo(String.valueOf(x)) > 0)) {
            return new StringBuilder().append(x).append(s).toString();
        }
        while ((String.valueOf(cur).compareTo(String.valueOf(x)) > 0)&&index<=s.length()-1) {
            index++;
            cur = s.charAt(index);
        }
        res.insert(index+1,x);
        return res.toString();
    }
}
