package com.oligizzz.algorithms.ApplicationQuestions;

/**
 * @Author: GNMD
 * @Description: 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。
 * 同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * 你按照如下规则进行一场游戏：
 * <p>
 * 1、你从第 0 天开始吃糖果。
 * 2、你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 3、在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * <p>
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。
 * answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，
 * 你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。
 * 注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * 请你返回得到的数组 answer
 * @Date: 2021/6/1
 * @Modify By:
 */
public class LeetCode1744 {

    public boolean[] canEat(int[] cs, int[][] qs) {

        int n = qs.length, m = cs.length;
        boolean[] ans = new boolean[n];
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + cs[i - 1];
        }
        for (int i = 0; i < n; i++) {
            int t = qs[i][0], d = qs[i][1] + 1, c = qs[i][2];
            long a = sum[t] / c + 1, b = sum[t + 1];
            ans[i] = a <= d && d <= b;
        }
        return ans;
    }

    /**
     * 宫水三叶
     *
     * @param cs 种类记录
     * @param qs 查询规则
     * @return
     */
    public boolean [] canEat2(int[] cs, int[][] qs) {
        //糖果种类数
        int m = cs.length;
        // 查询总数
        int n = qs.length;
        boolean[] res = new boolean[n];
        //处理前缀和，统计每种糖果之前一共有多少糖果
        long[] sum = new long[m + 1];
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + cs[i - 1];
        }
        // 模拟查询
        for (int i = 0; i < n; i++) {
            // 想吃的糖果种类
            int type = qs[i][0];
            // 想在哪天吃
            int day = qs[i][1]+1;
            // 最多能吃多少
            int max = qs[i][2];
            //最早能吃到糖果时间
            long lo = sum[type]/ max +1;
            // 最晚能吃到糖果的时间
            long hi = sum[type+1];
            // 能否在第day天吃到糖果
            res[i] = day>=lo&&day<=hi;

        }
        return res;
    }
}
