package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/30
 * @Modify By:
 */
public class LeetCode5772 {
    public static void main(String[] args) {
        LeetCode5772 leetCode5772 = new LeetCode5772();
        System.out.println(leetCode5772.isSumEqual("aaa", "a", "aab"));
    }
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        System.out.println(getInteger(firstWord));
        System.out.println(getInteger(secondWord));
        System.out.println(getInteger(targetWord));
        return getInteger(firstWord)+getInteger(secondWord)==getInteger(targetWord);
    }

    private static int getInteger(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == 'a' && sb.toString().equals("")){
                continue;
            }
            sb.append(String.valueOf(str.charAt(i)-'a'));
        }

        if(sb.toString().equals("")){
            return 0;
        }
        System.out.println(sb);
        return Integer.parseInt(sb.toString());
    }
}
