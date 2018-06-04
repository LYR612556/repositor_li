package com.niuke;

/**
 * 斐波那契数列
 * created by liyurong
 **/
public class Niuke8_1 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
    }
    public static int Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        int one = 0;
        int two = 1;
        for (int i = 2;i <= n;i ++){
            int tmp = one + two;
            one = two;
            two = tmp;
        }
        return two;
    }
}
