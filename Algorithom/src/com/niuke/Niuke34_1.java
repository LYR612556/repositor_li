package com.niuke;

/**
 * 丑数，使用数组保存中间结果
 * 判断丑数：https://my.oschina.net/liyurong/blog/1143037
 * 本题博客：https://my.oschina.net/liyurong/blog/1591743
 * created by liyurong
 **/
public class Niuke34_1 {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(0));//0
        System.out.println(GetUglyNumber_Solution(5));//5
        System.out.println(GetUglyNumber_Solution(10));//12
    }
    public static int GetUglyNumber_Solution(int n) {
        if (n == 0) return 0;
        int[] uglyNums = new int[n + 1];//保存所有的丑陋数
        uglyNums[1] = 1;
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2;i <= n;i ++){
            int min = Math.min(uglyNums[i2] * 2,Math.min(uglyNums[i3] * 3,uglyNums[i5] * 5));
            if (min == uglyNums[i2] * 2){
                i2 ++;
            }
            if (min == uglyNums[i3] * 3){
                i3 ++;
            }
            if (min == uglyNums[i5] * 5){
                i5 ++;
            }
            uglyNums[i] = min;
        }
        return uglyNums[n];
    }
}