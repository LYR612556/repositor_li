package com.niuke;

/**
 * Çó1+2+3+...+n
 * ²©¿ÍÎ»ÖÃ£ºhttps://my.oschina.net/liyurong/blog/1648786
 * created by liyurong
 **/
public class Niuke48_1 {
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