package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 */
public class Ofe05 {

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
