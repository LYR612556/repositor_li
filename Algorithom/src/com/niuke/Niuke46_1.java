package com.niuke;

/**
 * 不用加减和判断语句计算1+2+3+...+n,重点面试
 * 博客代码位置://my.oschina.net/liyurong/blog/1648786
 * created by liyurong
 **/
public class Niuke46_1 {
    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
        System.out.println(Sum_Solution(10));
    }
    public static int Sum_Solution(int n) {
        int sum = n;
        boolean tmp = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
