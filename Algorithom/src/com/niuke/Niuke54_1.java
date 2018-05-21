package com.niuke;

/**
 * 表示数值的字符串
 *
 * 博客位置：https://my.oschina.net/liyurong/blog/1648968
 * created by liyurong
 **/
public class Niuke54_1 {
    public static void main(String[] args) {
        System.out.println(isNumeric("+100".toCharArray()));
        System.out.println(isNumeric("5e2".toCharArray()));
        System.out.println(isNumeric("-123".toCharArray()));
        System.out.println(isNumeric("-1E-16".toCharArray()));
        System.out.println(isNumeric("3.1416".toCharArray()));
        System.out.println();
        System.out.println(isNumeric("12e".toCharArray()));
        System.out.println(isNumeric("1a3.14".toCharArray()));
        System.out.println(isNumeric("1.2.3".toCharArray()));
        System.out.println(isNumeric("+-5".toCharArray()));
        System.out.println(isNumeric("12e+4.3".toCharArray()));
    }
    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0){
            return false;
        }
        int index = 0;
        if (str[index] == '+' || str[index] == '-'){
            index ++;
        }
        if (index == str.length){
            return false;
        }
        index = scanDigits(str,index);
        if (index < str.length){
            if (str[index] == '.'){
                index ++;
                index = scanDigits(str,index);
                if (index < str.length){
                    if (str[index] == 'e' || str[index] == 'E'){
                        index ++;
                        return isExponential(str,index);
                    }
                    return false;
                }
                return true;
            }else if (str[index] == 'e' || str[index] == 'E'){
                index ++;
                return isExponential(str,index);
            }
            return false;
        }
        return true;
    }
    public static int scanDigits(char[] str,int index){
        while (index < str.length && str[index] >= '0' && str[index] <= '9'){
            index ++;
        }
        return index;
    }
    public static boolean isExponential(char[] str,int index){
        if (index < str.length){
            if (str[index] == '+' || str[index] == '-'){
                index ++;
            }
            index = scanDigits(str,index);
            if (index < str.length){
                return false;
            }
            return true;
        }
        return false;
    }
}
