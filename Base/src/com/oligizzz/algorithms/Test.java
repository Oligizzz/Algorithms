package com.oligizzz.algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/4/3
 * @Modify By:
 */
public class Test {


    public static void main(String[] args) {
        int [] a = new int[]{1,6,8,2,4,63,14};
        String [] temp = new String[a.length];
        for(int i = 0 ; i < a.length ; i ++){
            temp[i] = ""+a[i];
        }

        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuffer res = new StringBuffer();
        for (String s : temp) {
            res.append(s+" ");
        }
        System.out.println(res.toString());
    }
}
