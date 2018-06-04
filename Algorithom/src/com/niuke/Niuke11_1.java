package com.niuke;

/**
 * 矩形覆盖~
 * 博客位置：https://my.oschina.net/liyurong/blog/1823947
 * created by liyurong
 **/
public class Niuke11_1 {
    public static void main(String[] args) {
        System.out.println(RectCover(3));
    }
    public static int RectCover(int target) {
        if (target <= 1) return target;
        int one = 1;
        int two = 1;
        for (int i = 2;i <= target;i ++){
            int tmp = one + two;
            one = two;
            two = tmp;
        }
        return two;
    }
}
