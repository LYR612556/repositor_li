package com.niuke;

/**
 * 第一个只出现一次的字符
 * created by liyurong
 **/
public class Niuke35_1 {
    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("abac"));
    }
    public static int FirstNotRepeatingChar(String str) {
        int[] hash = new int[256];
        for (int i = 0;i < str.length();i ++){
            hash[str.charAt(i)] ++;
        }
        for (int i = 0;i < str.length();i ++){
            if (hash[str.charAt(i)] == 1){
                return i;
            }
        }
        return -1;
    }
}