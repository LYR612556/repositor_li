package com.niuke;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 博客位置：https://my.oschina.net/liyurong/blog/1631443
 * created by liyurong
 **/
public class Niuke22_1 {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] popB = {4,5,2,3,1};
        System.out.println(IsPopOrder(pushA,popA));
        System.out.println(IsPopOrder(pushA,popB));
    }
    public static boolean IsPopOrder(int [] pushA, int [] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0
                || pushA.length != popA.length) return false;
        int nextPush = 0;
        int nextPop = 0;
        Stack<Integer> stack = new Stack<>();
        while (nextPop < popA.length){
            while (nextPush < pushA.length && (stack.isEmpty() || stack.peek() != popA[nextPop])){
                stack.push(pushA[nextPush]);
                nextPush ++;
            }
            if (stack.peek() == popA[nextPop]){
                stack.pop();
                nextPop ++;
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}