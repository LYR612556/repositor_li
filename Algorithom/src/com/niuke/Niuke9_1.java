package com.niuke;

/**
 * 跳台阶,斐波拉契数列
 * created by liyurong
 **/
public class Niuke9_1 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
    public static int JumpFloor(int target) {
        if (target <= 0) return target;
        int fir = 1;
        int two = 1;
        for (int i = 2;i <= target;i ++){
            int tmp = fir + two;
            fir = two;
            two = tmp;
        }
        return two;
    }
}