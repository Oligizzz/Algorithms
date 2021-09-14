package com.oligizzz.algorithms.String;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/1
 * @Modify By:
 */
public class LeetCode165 {
    public static void main(String[] args) {
        LeetCode165 test = new LeetCode165();
        System.out.println(test.compareVersion("1.0", "1.0.0.0.0"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Len = v1.length;
        int v2Len = v2.length;
        int max = Math.max(v1Len, v2Len);
        int i = 0;
        for (; i < max; i++) {
            int a = i < v1Len ? paserInt(v1[i]) : 0;
            int b = i < v2Len ? paserInt(v2[i]) : 0;
            int temp = a - b;
            if (temp != 0) {
                return a - b > 0 ? 1 : -1;
            }
        }
        return 0;
    }


    private int paserInt(String str) {
        int i = 0;
        for (; "0".equals(str.charAt(i)); ) {
            i++;
        }
        System.out.println(Integer.parseInt(str.substring(i)));
        return Integer.parseInt(str.substring(i));
    }
}
