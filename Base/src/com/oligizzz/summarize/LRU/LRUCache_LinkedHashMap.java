package com.oligizzz.summarize.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Oligizzz
 * @Description:
 * @Date: 2021/9/14
 * @Modify By:
 */
public class LRUCache_LinkedHashMap {
    /**
     * 最大容量
     */
    int capacity;
    /**
     * 缓存数据
     */
    Map<Integer, Integer> cache;

    public LRUCache_LinkedHashMap(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>();
    }

    public int get(int key) {
        //不存在返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }
        // 存在的话移动到最右边，返回值
        Integer value = cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        //存在的话，删除后放置到末尾
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }

        //如果不存在,直接放到最后面
        cache.put(key, value);
        if (cache.size() > capacity) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }


    }
}
