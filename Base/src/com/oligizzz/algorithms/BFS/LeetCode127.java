package com.oligizzz.algorithms.BFS;

import java.util.*;

/**
 * @Author: GNMD
 * @Description: 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
 * <p>
 * 序列中第一个单词是 beginWord 。
 * 序列中最后一个单词是 endWord 。
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典 wordList 中的单词。
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 * @Date: 2021/6/25
 * @Modify By:
 */
public class LeetCode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (words.size() == 0 || !words.contains(endWord)) {
            return 0;
        }
        words.remove(beginWord);

        //广度优先遍历起点入队
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //广度优先使用的visited数组
        Set<String> visited = new HashSet<>();
        //入队就表示遍历过
        visited.add(beginWord);

        //起点算一步
        int step = 1;
        //开始广度优先遍历
        while (!queue.isEmpty()) {
            int curLength = queue.size();
            for (int i = 0; i < curLength; i++) {
                //依次处理队列中的元素
                String curWord = queue.poll();
                //是否能转换为endWord
                if (canChangeToEndWord(curWord, words, endWord, queue, visited)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }


    private boolean canChangeToEndWord(String curWord, Set<String> wordList, String endWord, Queue<String> queue, Set<String> visited) {
        char[] curWordArr = curWord.toCharArray();
        //依次尝试修改每一个位置
        for (int i = 0; i < curWordArr.length; i++) {
            char origin = curWordArr[i];
            //尝试每一种修改方法，去和wordList去对应
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == origin) {
                    continue;
                }
                curWordArr[i] = c;
                String changed = String.valueOf(curWordArr);
                //看看单词表中是否有这个单词可转换
                if (wordList.contains(changed)) {
                    //再看看是不是最后一个单词，是的话就直接返回
                    if (endWord.equals(changed)) {
                        return true;
                    }
                    //不是的话就正常的入队操作,前提是没有被visited
                    if (!visited.contains(changed)) {
                        queue.offer(changed);
                        visited.add(changed);
                    }
                }
                curWordArr[i] = origin;
            }
        }
        return false;
    }
}
