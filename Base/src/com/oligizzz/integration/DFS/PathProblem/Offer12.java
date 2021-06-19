package com.oligizzz.integration.DFS.PathProblem;

/**
 * @Author: GNMD
 * @Description: 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Date: 2021/6/14
 * @Modify By:
 */
public class Offer12 {
    char[][] board;
    char[] word;

    public boolean exist(char[][] _board, String _word) {
        board = _board;
        word = _word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(int i, int j, int curIndex) {
        // 剪枝条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[curIndex]) {
            return false;
        }

        // 递归出口
        if (curIndex == word.length - 1) {
            return true;
        }

        // 标记为使用过
        board[i][j] = '#';
        boolean res = dfs(i - 1, j, curIndex + 1) ||
                dfs(i + 1, j, curIndex + 1) ||
                dfs(i, j - 1, curIndex + 1) ||
                dfs(i, j + 1, curIndex + 1);
        // 回溯
        board[i][j] = word[curIndex];
        return res;

    }


}
