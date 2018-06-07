package com.coder.StackAndQueue;

import java.util.Stack;

/**
 * 最大子矩阵的大小
 * created by liyurong
 **/
public class MaxSubMatrix {
    public static void main(String[] args) {
        int[][] maxtrix = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(getMaxRecSize(maxtrix));
    }
    public static int getMaxRecSize(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];//保存每列的最大相邻为1的个数
        int maxArea = 0;
        for (int i = 0;i < n;i ++){
            for (int j = 0;j < m;j ++){
                height[j] = matrix[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea,getMaxArea(height));
        }
        return maxArea;
    }
    public static int getMaxArea(int[] height){
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();//找到右侧第一个比当前值小的下标
        int maxArea = 0;
        for (int i = 0;i < height.length;i ++){
            while (! stack.isEmpty() && height[i] <= height[stack.peek()]){
                int j = stack.pop();
                int k = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - k - 1) * height[j];
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (! stack.isEmpty()){
            int j = stack.pop();
            int k = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - k - 1) * height[j];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}