package com.oligizzz.algorithms.String;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/7/24
 * @Modify By:
 */
public class LeetCode1736 {
    public static void main(String[] args) {
        System.out.println(LeetCode1736.maximumTime("1?:22"));
    }

    public static String maximumTime(String time) {
        StringBuilder res = new StringBuilder();
        char h = time.charAt(0);
        boolean tag = h == '2' || (h == '?' && time.charAt(1) <= '3') || (h == '?' && time.charAt(1) == '?')? true : false;
        if(time.charAt(0)=='?'){res.append(tag?'2':time.charAt(0)!='?'?time.charAt(0):'1');}else{res.append(time.charAt(0));}
        if(time.charAt(1)=='?'){res.append(tag?'3':'9');}else{res.append(time.charAt(1));}
        res.append(':');
        if(time.charAt(3) == '?'){res.append('5');}else{res.append(time.charAt(3));}
        if(time.charAt(4)=='?'){res.append('9');}else{res.append(time.charAt(4));}
        return res.toString();
    }
}
