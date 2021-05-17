package com.oligizzz.algorithms.Competition;

import java.util.Arrays;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/5/16
 * @Modify By:
 */
public class LeetCode5760 {
    public static void main(String[] args) {
        LeetCode5760 leetCode5760 = new LeetCode5760();
        System.out.println(leetCode5760.minSwaps("1110"));
    }

    public int minSwaps(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }
        if (len == 2) {
            return s.charAt(0) != s.charAt(1) ? 0 : -1;
        }
        char[] c = s.toCharArray();
        int count0 = 0;
        int count1 = 0;

        for (char a : c) {
            if (a == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }


        if (Math.abs(count0 - count1) == 1) {
            int count5 = 0;
            char[] temp = new char[len];
            temp[0] = count0 > count1 ? '0' : '1';
            for (int i = 1; i < len; i++) {
                if (i % 2 == 0) {
                    temp[i] = temp[0];
                } else {
                    temp[i] = temp[0] == '0' ? '1' : '0';
                }
            }
            for (int j = 0; j < len; j++) {
                if (temp[j] != c[j]) {
                    count5++;
                }

            }
            //System.out.println(count3+" "+count4);
            return count5 / 2;

        } else {
            int count3 = 0;
            int count4 = 0;
            char[] temp1 = new char[len];
            char[] temp2 = new char[len];
            temp1[0] = '0';
            temp2[0] = '1';
            for (int i = 1; i < len; i++) {
                if (i % 2 == 0) {
                    temp1[i] = temp1[0];
                    temp2[i] = temp2[0];
                } else {
                    temp1[i] = temp1[0] == '0' ? '1' : '0';
                    temp2[i] = temp2[0] == '0' ? '1' : '0';
                }
            }
            for (int j = 0; j < len; j++) {
                if (temp1[j] != c[j]) {
                    count3++;
                }
                if (temp2[j] != c[j]) {
                    count4++;
                }
            }
//            System.out.println(count3 + " " + count4);
//            System.out.println(Arrays.toString(temp1) + "  " + Arrays.toString(temp2) + "  " + Arrays.toString(c));
            return Math.min(count3 / 2, count4 / 2);
        }


    }

}
