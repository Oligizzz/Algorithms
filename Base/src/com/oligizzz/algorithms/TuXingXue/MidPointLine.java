package com.oligizzz.algorithms.TuXingXue;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/6
 * @Modify By:
 */
public class MidPointLine {

    public static void main(String [] args){
        MidPointLine midPointLine = new MidPointLine();
        midPointLine.dda(0,0,150,150);
        midPointLine.solution(0,0,150,150);
        midPointLine.MidPointCircle(195);
    }

    public void dda(int x0 , int y0 , int x1 , int y1){
        StdDraw.setXscale(0,200);
        StdDraw.setYscale(0,200);
        StdDraw.setPenRadius(0.005);

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

    public void solution(int x0 ,int y0 ,int x1, int  y1){
        StdDraw.setXscale(0,200);
        StdDraw.setYscale(0,200);
        StdDraw.setPenRadius(0.005);

        int a = y0 - y1;
        int b = x1 - x0;
        int d = 2*a +b;
        int delta1 = 2*a;
        int delta2 = 2*(a +b);

        int x = x0;
        int y = y0;
        StdDraw.point(x,y);

        while(x < x1){
            if(d < 0){
                x++;
                y++;
                d+=delta2;
            }else{
                x++;
                d+=delta1;
            }
            StdDraw.point(x,y);
        }

    }


    public void bresenham(int x0 ,int y0 ,int x1, int  y1){
        StdDraw.setXscale(0,200);
        StdDraw.setYscale(0,200);
        StdDraw.setPenRadius(0.005);

        int x = x0;
        int y = y0;
        double k = (y1 - y0)/(x1- x0);

        double e = -0.5;
        for(int i = x0; i < (x1- x0) ; i++){
            StdDraw.point(x,y);
            x +=1;
            e +=k;
            if(e>=0){
                y+=1;
                e -=1;
            }
        }
    }

    public void MidPointCircle(int R){
        StdDraw.setXscale(0,200);
        StdDraw.setYscale(0,200);
        StdDraw.setPenRadius(0.005);

        int x = 0;
        int y = R;
        double d = 1.25 - R;
        StdDraw.point(x,y);

        while(x < y){
            if(d < 0){
                d += 2*x +3;
                x++;
            }else{
                d+=2*(x-y)+5;
                x++;
                y--;
            }
            StdDraw.point(x,y);
            StdDraw.point(y,x);
        }

    }
}
