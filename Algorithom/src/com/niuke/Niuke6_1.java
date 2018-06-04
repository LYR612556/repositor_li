package com.niuke;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * created by liyurong
 **/
public class Niuke6_1 {
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
    }
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        while (! stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack2.push(node);
        while (! stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public static int pop() {
        return stack1.pop();
    }
}
