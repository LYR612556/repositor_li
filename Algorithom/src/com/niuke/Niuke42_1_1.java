package com.niuke;

/**
 * 左旋转字符串,三次翻转
 * created by liyurong
 **/
public class Niuke42_1_1 {
    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
    public static String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return str;
        char[] schar = str.toCharArray();
        n = n % schar.length;
        reverse(schar,0,n - 1);
        reverse(schar,n,schar.length - 1);
        reverse(schar,0,schar.length - 1);
        return new String(schar);
    }
    public static void reverse(char[] schar,int i,int j){
        while (i < j){
            char tmp = schar[i];
            schar[i] = schar[j];
            schar[j] = tmp;
            i ++;
            j --;
        }
    }
}