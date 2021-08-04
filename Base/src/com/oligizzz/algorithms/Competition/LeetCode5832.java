package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/1
 * @Modify By:
 */
public class LeetCode5832 {
    public static void main(String[] args) {
        LeetCode5832 test = new LeetCode5832();
        System.out.println(test.minimumPerimeter(1000000000));
    }

    public long minimumPerimeter(long neededApples) {
        if(neededApples<12){
            return 2;
        }
        long can = 12;
        long start = 2;

        while(can < neededApples){
            start+=2;
            can = 8+4*(start-1);

        }
        System.out.println(can+" "+start);
        return start*4;
    }


}
