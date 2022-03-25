package com.oligizzz.algorithms.Offer;

/**
 * @author: chunzhao
 * @time: 2022/3/23
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用
 */
public class Ofe12 {
    public static void main(String[] args) {
        Ofe12 test= new Ofe12();
        System.out.println(test.exist(new char[][]{{'a'}}, "ab"));
    }
    char[][] board;
    public boolean exist(char[][] b, String word) {
        board = b;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (dfs(i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int cur, String str) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != str.charAt(cur)) {
            return false;
        }
        if (cur == str.length() - 1) {
            return true;
        }
        board[i][j] = '@';
        boolean res = dfs(i, j - 1, cur + 1, str)
                || dfs(i, j + 1, cur + 1, str)
                || dfs(i - 1, j, cur + 1, str)
                || dfs(i + 1, j , cur + 1, str);
        board[i][j] = str.charAt(cur);
        return res;

    }
}
