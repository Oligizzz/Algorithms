package com.oligizzz.algorithms.Stack.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: GNMD
 * @Description: 直方图的水量
 * @Date: 2021/4/2
 * @Modify By:
 */
public class WaterVolumeOfHistogram {
    /**
     * 直方图水量
     * @param height 直方图的高度
     * @return 不同高度正方体排列后能够装下的水量
     */
    public int trap(int[] height) {
        int res = 0;
        int n  = height.length;
        // 维护的单调栈
        Deque<Integer> stack = new LinkedList<>();
        // 依次处理每个柱子
        for(int i = 0 ; i < n ; i ++){
            // 如果发现当前柱子比栈顶柱子高，那么开始做出栈处理
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 被出栈柱子的高度
                int outHeight = height[stack.pop()];
                // 出完栈后发现栈里没有柱子了，说明刚才出栈柱子的左边已经没有柱子了,
                // 此时应该退出循环，直接把当前柱子入栈（满足单调）
                if(stack.isEmpty()){ break;}
                // 弹栈左边柱子高度
                int leftHeight = height[stack.peek()];
                //弹栈右边柱子高度
                int rightHeight = height[i];
                // 计算能围成的正方体高度
                int curHeight = Math.min(leftHeight , rightHeight) - outHeight;

                //计算宽度
                int curWidth = i - stack.peek() - 1;
                res += curHeight*curWidth;

            }
            // 加入当前柱子，保持单调递减
            stack.push(i);
        }
        return res;
    }
}
