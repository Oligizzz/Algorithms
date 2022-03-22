package com.oligizzz.algorithms.String;

/**
 * @author: chunzhao
 * @time: 2022/3/22
 * <p>
 * 总共有 n 个颜色片段排成一列，每个颜色片段要么是 'A' 要么是 'B' 。给你一个长度为 n 的字符串 colors ，其中 colors[i] 表示第 i 个颜色片段的颜色。
 * <p>
 * Alice 和 Bob 在玩一个游戏，他们 轮流 从这个字符串中删除颜色。Alice 先手 。
 * <p>
 * 如果一个颜色片段为 'A' 且 相邻两个颜色 都是颜色 'A' ，那么 Alice 可以删除该颜色片段。Alice 不可以 删除任何颜色 'B' 片段。
 * 如果一个颜色片段为 'B' 且 相邻两个颜色 都是颜色 'B' ，那么 Bob 可以删除该颜色片段。Bob 不可以 删除任何颜色 'A' 片段。
 * Alice 和 Bob 不能 从字符串两端删除颜色片段。
 * 如果其中一人无法继续操作，则该玩家 输 掉游戏且另一玩家 获胜 。
 * 假设 Alice 和 Bob 都采用最优策略，如果 Alice 获胜，请返回 true，否则 Bob 获胜，返回 false。
 * AAAAABBB AABBBAAA BBBBAAABAAA ABAB
 */
public class LeetCode2038 {

    public static void main(String[] args) {
        LeetCode2038 test = new LeetCode2038();
        System.out.println(test.winnerOfGame("AABBBAAA"));
    }

    public boolean winnerOfGame(String colors) {
        int a = 0, b = 0;
        char[] arr = colors.toCharArray();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] == 'A' && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                a++;
            }
            if (arr[i] == 'B' && arr[i] == arr[i - 1] && arr[i] == arr[i + 1]) {
                b++;
            }
        }
        return a > b;
    }
}
