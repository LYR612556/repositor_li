package com.coder.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**最大值减去最小值小于或等于num的子数组数量,滑动窗口
 * created by liyurong
 **/
public class MaxMinDiff {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};//13
        System.out.println(getNum(arr,1));
    }
    public static int getNum(int[] arr,int num){
        if (arr == null || arr.length == 0) return 0;
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (! qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (! qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j ++;
            }
            if (qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            res += j - i;
            i ++;
        }
        return res;
    }
}