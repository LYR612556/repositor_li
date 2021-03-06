package com.niuke;

/**
 * 翻转单词序列
 * created by liyurong
 **/
public class Niuke42_2_1 {
    public static void main(String[] args) {
        System.out.println(" ");
        System.out.println(ReverseSentence("student. a am I"));
    }
    public static String ReverseSentence(String str) {
        if (str.trim() == null || str.trim().length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        String[] strs = str.split("\\s+");
        for (int i = strs.length - 1;i >= 0;i --){
            sb.append(strs[i]);
            if (i != 0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
