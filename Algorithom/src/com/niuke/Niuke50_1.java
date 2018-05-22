package com.niuke;

/**
 * 把字符串转换为整数
 * 博客位置：https://my.oschina.net/liyurong/blog/1523594
 * created by liyurong
 **/
public class Niuke50_1 {
    public static void main(String[] args) {
        System.out.println(StrToInt(""));
        System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("-2147483647"));
        System.out.println(StrToInt("+2345678765432123456"));
        System.out.println(StrToInt("-2345676543234543"));
        System.out.println(StrToInt("1a33"));
        System.out.println(StrToInt("  -0012a42"));
    }
    public static int StrToInt(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) return 0;
        double res = 0;
        int flag = 1;
        int i = 0;
        if (str.charAt(i) == '-'){
            i ++;
            flag = -1;
        }else if (str.charAt(i) == '+'){
            i ++;
        }
        while (i < str.length()){
            if (str.charAt(i) > '9' || str.charAt(i) < '0'){
                return 0;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                res = res * 10 + str.charAt(i) - '0';
            }
            i ++;
        }
        res = flag * res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}