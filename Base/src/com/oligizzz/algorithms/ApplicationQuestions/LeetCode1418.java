package com.oligizzz.algorithms.ApplicationQuestions;

import java.util.*;

/**
 * @Author: GNMD
 * @Description:
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说， orders[i]=[customerNamei,tableNumberi,foodItemi] ，
 * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，后面每一列都是按字母顺序排列的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列
 * @Date: 2021/7/7
 * @Modify By:
 */
public class LeetCode1418 {
    public static void main(String[] args) {
        List<List<String>> orders = new ArrayList<>();
        orders.add(Arrays.asList(new String[]{"David","3","Ceviche"}));
        orders.add(Arrays.asList(new String[]{"Corina","10","Beef Burrito"}));
        orders.add(Arrays.asList(new String[]{"David","3","Fried Chicken"}));
        orders.add(Arrays.asList(new String[]{"Carla","5","Water"}));
        orders.add(Arrays.asList(new String[]{"Carla","5","Ceviche"}));
        orders.add(Arrays.asList(new String[]{"Rous","3","Ceviche"}));
        System.out.println(displayTable(orders));
    }
    /**
     *
     * @param orders 订单条目
     * @return
     */
    public static List<List<String>> displayTable(List<List<String>> orders) {
        //记录菜品
        Set<String> menu = new TreeSet<>();
        // 依次处理每个餐桌，每个餐桌的每个菜都点了多少
        Map<Integer, Map<String,Integer>> temp = new HashMap<>();
        for(List<String> cur : orders){
            String curFood = cur.get(2);
            //先加入菜单中
            menu.add(curFood);
            // 餐桌号
            int num = Integer.parseInt(cur.get(1));
            //处理该餐桌的点菜数目
            Map<String,Integer> curDiningTable = temp.getOrDefault(num,new HashMap<String,Integer>());
            curDiningTable.put(curFood,curDiningTable.getOrDefault(curFood,0)+1);
            temp.put(num,curDiningTable);
        }

        TreeMap<Integer,Map<String,Integer>> treeMap = new TreeMap<>(temp);
        //依次处理每个餐桌
        List<List<String>> res = new ArrayList<>();
        List<String> tableHead = new ArrayList<>(menu.size()+1);
        tableHead.add("Table");
        for(String s : menu){
            tableHead.add(s);
        }
        res.add(tableHead);
        for(Map.Entry<Integer,Map<String,Integer>> entry : treeMap.entrySet()){
            List<String> curTable = new ArrayList<>();
            curTable.add(entry.getKey()+"");
            Map<String,Integer> curMenu = entry.getValue();
            for(String s : menu){
                curTable.add(curMenu.getOrDefault(s,0)+"");
            }
            res.add(curTable);
        }
        return res;
    }
}
