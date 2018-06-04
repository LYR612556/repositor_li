package com.niuke;

/**
 * 替换空格
 * created by liyurong
 **/
public class Niuke4_1 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
    }
    public static String replaceSpace(StringBuffer str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String str1 = str.toString();
        StringBuilder res = new StringBuilder();
        for (int i = 0;i < str1.length();i ++){
            if (str1.charAt(i) == ' '){
                res.append("%20");
            }else {
                res.append(str1.charAt(i));
            }
        }
        return res.toString();
    }
}
