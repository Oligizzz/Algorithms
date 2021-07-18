package com.oligizzz.algorithms.String;

import java.util.*;

import static java.util.Arrays.*;

/**
 * @Author: GNMD
 * @Description: 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * @Date: 2021/7/18
 * @Modify By:
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.getHash("pup"));
        System.out.println(g.getHash("hos"));
        System.out.println(g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            int hash = getHash(str);
            if (map.containsKey(hash)) {
                res.get(map.get(hash)).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                res.add(newList);
                map.put(hash, res.size() - 1);
            }
        }
        return res;
    }

    private int getHash(String str) {
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        int hash = 0;
        for (int i = 0; i < temp.length; i++) {
            hash = 31 * hash + temp[i];
        }
        return hash;
    }
}
