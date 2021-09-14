package com.oligizzz.algorithms.Competition;

/**
 * @Author: GNMD
 * @Description:
 * @Date: 2021/8/7
 * @Modify By:
 */
public class LeetCode5193 {
    public static void main(String[] args) {
        LeetCode5193 test= new LeetCode5193();
        System.out.println(test.makeFancyString("aaabaaaaaaabbbbbaaa"));
    }

    public String makeFancyString(String s) {
        if (s.length() <=2){
            return s;
        }
        char [] res= s.toCharArray();
        //1.定义两个指针，目标指针j、待移动指针均i从1开始，初始化计数器count=1
        int j = 1;
        int count = 1;
        //2.从1开始遍历整个数组
        for(int i = 1;i < s.length();i++){
            //3.如果该数与前一个相等则计数器+1，否则计数器重置为1
            if(res[i] == res[i-1]){
                count++;
            }else{
                count = 1;
            }
            //4.如果计数器的值小于等于2，则将此时i处的值赋给j处
            if(count <= 2){
                res[j] = res[i];
                //j自增到下一个需要赋值的位置
                j++;
            }
        }
        //由于在循环中j已经自增，所以返回j的值，就是数组的新长度
        return new String(res,0,j);

    }
}
