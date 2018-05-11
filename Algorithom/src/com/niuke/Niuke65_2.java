package com.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * 滑动窗口的最大值，使用栈辅助计算
 *
 **/
public class Niuke65_2 {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num,3).toString());
    }
    public static ArrayList<Integer> maxInWindows(int[] num,int size){
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0){
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<>();//用于模拟栈
        for (int i = 0;i < num.length;i ++){
            while (! deque.isEmpty() && (i - deque.peekFirst()) == size){//栈中的元素超过最大窗口
                deque.pollFirst();
            }
            while (! deque.isEmpty() && num[i] >= num[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= (size - 1)){
                res.add(num[deque.peekFirst()]);
            }
        }
        return res;
    }
}