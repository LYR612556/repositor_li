package com.niuke;

/**
 * 数值的整数次方
 * 博客位置：https://my.oschina.net/liyurong/blog/1529222
 * 进化版博客位置：https://my.oschina.net/liyurong/blog/1595790
 * created by liyurong
 **/
public class Niuke13_1 {
    public static void main(String[] args) {
        System.out.println(Power(2,10));
    }
    public static double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent > 0){
            return pow(base,exponent);
        }else {
            return 1 / pow(base,Math.abs(exponent));
        }
    }
    public static double pow(double base,int exponent){
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double tmp = pow(base,exponent >> 1);
        if ((exponent & 1) == 1){
            return tmp * tmp * base;
        }else {
            return tmp * tmp;
        }
    }
}