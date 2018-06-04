package com.niuke;

import java.util.Stack;

/**
 * 包含min函数的栈
 * 博客位置：https://my.oschina.net/liyurong/blog/1511264
 * created by liyurong
 **/
public class Niuke21_1 {
    public static void main(String[] args) {
        push(4);
        System.out.println(min());
        push(5);
        System.out.println(min());
        push(3);
        System.out.println(min());
        push(2);
        System.out.println(min());
        pop();
        System.out.println(min());
        System.out.println(top());
    }
    static Stack<Integer> stack = new Stack<>();
    static int minVal = Integer.MAX_VALUE;
    public static void push(int node) {
        if (node <= minVal){
            stack.push(minVal);
            minVal = node;
        }
        stack.push(node);
    }

    public static void pop() {
        if (stack.pop() == minVal){
            minVal = stack.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int min() {
        return minVal;
    }
}