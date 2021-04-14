package com.oligizzz.algorithms.Tree;

/**
 * @Author: GNMD
 * @Description: 前缀树的实现
 * @Date: 2021/4/14
 * @Modify By:
 */
public class LeetCode208 {
    /**
     * 二维数组实现
     */
    class Trie1 {
        int N = 100009;
        int [][] trie;
        int [] count;
        int index;

        /** Initialize your data structure here. */
        public Trie1() {
            //每个单词字符
            trie = new int[N][26];
            //每个格子被标记为结尾的次数（以此位置结尾的单词的个数）
            count = new int[N];
            //真正使用到格子数量
            index = 0;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            //从第一个格子开始查找
            int p = 0 ;
            for(int i = 0;i < word.length(); i ++){
                //取出当前字符
                int u  = word.charAt(i) - 'a';
                //当前格子没有的话，就加一个
                if(trie[p][u] == 0){trie[p][u] = ++index;}
                //加完之后，刷新为下次搜索的起点
                p = trie[p][u];
            }
            //家湾一个单词就在当前位置标记一次结尾标记
            count[p]++;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            int p = 0 ;
            for(int i = 0 ; i < word.length(); i ++){
                int u = word.charAt(i) - 'a';
                if(trie[p][u] == 0){return false;}
                p = trie[p][u];
            }
            return count[p]!=0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int p = 0 ;
            for(int i = 0 ; i <prefix.length() ; i ++){
                int u = prefix.charAt(i) - 'a';
                if(trie[p][u] == 0 ){ return  false;}
                p = trie[p][u];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
