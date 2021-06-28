package com.oligizzz.algorithms.EnumerationProblem;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/6/22
 * @Modify By:
 */
public class Offer38 {
    public static void main(String[] args) {
        Offer38 offer38 = new Offer38();
        System.out.println(Arrays.toString(offer38.permutation("abc")));
        int a  = Integer.bitCount(12);
    }

    char[] arr;
    public String[] permutation(String s) {
        arr = s.toCharArray();
        List<String> res = new ArrayList<>();
        dfs(new boolean[arr.length], 0, new StringBuilder(), res);
        Set<String> set = new HashSet<>();
        for (String str : res) {
            set.add(str);
        }
        String[] result = new String[set.size()];
        Iterator<String> it = set.iterator();
        int index = 0;
        while (it.hasNext()) {
            result[index++] = it.next();
        }
        return result;
    }

    private void dfs(boolean[] used, int index, StringBuilder path, List<String> res) {
        if (index == arr.length) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.append(arr[i]);
                dfs(used, index + 1, path, res);
                used[i] = false;
                path.delete(path.length() - 1, path.length());
            } else {
                continue;
            }
        }
    }
}
