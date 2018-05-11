package com.niuke;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 *
 * �������ڵ����ֵ��ʹ��ջ��������
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
        Deque<Integer> deque = new ArrayDeque<>();//����ģ��ջ
        for (int i = 0;i < num.length;i ++){
            while (! deque.isEmpty() && (i - deque.peekFirst()) == size){//ջ�е�Ԫ�س�����󴰿�
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