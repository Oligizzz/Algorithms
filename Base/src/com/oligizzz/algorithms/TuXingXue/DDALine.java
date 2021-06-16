package com.oligizzz.algorithms.TuXingXue;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/6
 * @Modify By:
 */
public class DDALine {
    public static void main(String[] args) {
        DDALine ddaLine = new DDALine();
        ddaLine.dda(1,1,15,15);
    }


    public void dda(int x0 , int y0 , int x1 , int y1){
        StdDraw.setXscale(0,20);
        StdDraw.setYscale(0,20);
        StdDraw.setPenRadius(0.01);

        //每次要画的点
        int x,y;
        // 斜率
        double k = (y1 - y0)/(x1 - x0);
        // 初始化起点
        y = y0;
        for( x = x0 ; x <= x1 ; x++){
            StdDraw.point((double)x,(double)(int)(y+0.5));
            y+=k;
        }
    }
}
