package com.coder.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 生成窗口最大值数组，滑动窗口最大值,双端队列
 * created by liyurong
 **/
public class MaxWindow {
    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(arr,3);
        for (int n : res){
            System.out.print(n + " ");
        }
    }
    public static int[] getMaxWindow(int[] arr,int w){
        if (arr == null || w < 1 || arr.length < w){
            return null;
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0;i < arr.length;i ++){
            while (! deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (deque.peekFirst() == i - w){
                deque.pollFirst();
            }
            if (i >= w - 1){
                res[index ++] = arr[deque.peekFirst()];
            }
        }
        return res;
    }
}