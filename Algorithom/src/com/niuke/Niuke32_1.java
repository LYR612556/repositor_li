package com.niuke;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次)
 * 博客地址：https://my.oschina.net/liyurong/blog/1635763
 * created by liyurong
 **/
public class Niuke32_1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(10));
        System.out.println(NumberOf1Between1AndN_Solution(21345));//18821
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) return 0;
        String num = n + "";
        return dfs(num);
    }
    public static int dfs(String num){
        if (num == null || num.length() == 0){
            return 0;
        }
        int len = num.length();
        if (len == 1 && num.charAt(0) - '0' == 0){
            return 0;
        }
        if (len == 1 && num.charAt(0) - '0' >= 1){
            return 1;
        }
        int firCount = 0;
        int otherCount = 0;
        int recurCount = 0;
        if (num.charAt(0) - '0' > 1){
            firCount = (int) Math.pow(10,len - 1);
        }
        if (num.charAt(0) - '0' == 1){
            firCount = Integer.valueOf(num.substring(1)) + 1;
        }
        otherCount = (num.charAt(0) - '0') * (len - 1) * (int) Math.pow(10,len - 2);
        recurCount = dfs(num.substring(1));
        return firCount + otherCount + recurCount;
    }
}