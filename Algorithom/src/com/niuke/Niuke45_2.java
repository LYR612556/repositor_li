package com.niuke;

/**
 * 孩子们的游戏
 * created by liyurong
 **/
public class Niuke47_2 {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(6,3));
        System.out.println(LastRemaining_Solution(6,4));
    }
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0) return -1;
        int last = 0;
        for (int i = 2;i <= n;i ++){
            last = (last + m) % i;
        }
        return last;
    }
}