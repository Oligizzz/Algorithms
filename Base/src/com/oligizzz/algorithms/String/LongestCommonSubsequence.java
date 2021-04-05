package com.oligizzz.algorithms.String;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        String a = "hofubmnylkra";        String b = "pqhgxgdofcvmr";
        System.out.println(l.longestCommonSubsequence1(a, b));
    }
    /**
     *  暴力法
     * @param text1 串一
     * @param text2 串二
     * @return 公共子序列长度
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int res = 0;
        int len1 = text1.length();
        int len2 = text2.length();
        if(len1>=len2){
            for(int i = 0 ; i < text2.length() ; i ++){
                for(int j = i ; j <= text2.length() ; j++){
                    String subText2 = text2.substring(i,j);
                    res = Math.max(res , isSubSequence(text1,subText2));
                }
            }
        }else {
            for(int i = 0 ; i < text1.length() ; i ++){
                for(int j = i ; j <= text1.length() ; j++){
                    String subText1 = text1.substring(i,j);
                    res = Math.max(res , isSubSequence(text2,subText1));
                }
            }
        }
        return res;
    }

    /**
     * 判断是不是子序列，是的话直接返回长度，不是的话返回0
     * @param str1 主串
     * @param str 模式串
     * @return 匹配长度
     */
    private int isSubSequence(String str1, String str) {
        int index = 0;
        int count = 0;
        int i = 0;
        for(; i <str.length() ; i ++){
            for(int j = index ; j < str1.length() ; j ++){
                if(str.charAt(i)==str1.charAt(j)){
                    count++;
                    index = j;
                    break;
                }
            }
        }

        if(count == str.length()){
            return str.length();
        }else{
            return 0;
        }
    }


}
