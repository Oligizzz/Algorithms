package com.oligizzz.algorithms.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: GNMD
 * @Description: 笨阶乘 模拟逆波兰式
 * @Date: 2021/4/1
 * @Modify By:
 */
public class LeetCode1006 {
    public static void main(String[] args) {
        LeetCode1006 lc = new LeetCode1006();
        System.out.println(lc.clumsy(4));
    }
    public int clumsy(int N) {
        //操作数栈
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N);
        N--;

        //控制符号
        int operation = 0;
        while(N > 0){
            if(operation % 4 == 0){
                stack.push(stack.pop()*N);
            }else if(operation %  4 == 1 ){
                stack.push(stack.pop()/N);
            }else if(operation %4 == 2){
                stack.push(N);
            }else{
                stack.push( -N );
            }
            operation++;
            N--;
        }

        int res = 0 ;

        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
