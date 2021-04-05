package com.oligizzz.algorithms.Math;

/**
 * @Author: GNMD
 * @Description: 直方图水量（数学暴力）
 * @Date: 2021/4/2
 * @Modify By:
 */
public class WaterVolumeOfHistogram {
    public static void main(String[] args) {
        WaterVolumeOfHistogram waterVolumeOfHistogram = new WaterVolumeOfHistogram();
        System.out.println(waterVolumeOfHistogram.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public int trap(int [] height){
        int n = height.length;
        int res = 0 ;

        // 求每个柱子能够接到的水量
        for(int i = 1 ; i < n - 1 ; i ++){
            res+=canFillWithWater(height ,i);
        }
        return res;
    }

    private int canFillWithWater(int [] height, int cur) {
        int water = 0;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        // 获取左边最大值
        for(int i = cur -1 ; i >=0 ; i --){
            left = Math.max(height[i],left);
        }
        if(left <= height[cur]){ return 0;}

        for(int j = cur +1 ; j < height.length ; j ++){
            right = Math.max(height[j], right);
        }
        if(right <= height[cur]){ return 0;}

        water = Math.min(left ,right) - height[cur];
        return water;
    }


}
