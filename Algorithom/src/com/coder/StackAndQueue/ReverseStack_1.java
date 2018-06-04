package com.coder.StackAndQueue;

import java.util.Stack;

/**
 * 使用递归函数和栈操作逆序一个栈，P8
 * created by liyurong
 **/
public class ReverseStack_1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
//        while (! stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//        System.out.println();
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int res = stack.pop();
        if (stack.isEmpty()){
            return res;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(res);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()) return;
        int val = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(val);
    }
}