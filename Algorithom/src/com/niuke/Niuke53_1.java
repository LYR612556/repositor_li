package com.niuke;

/**
 * 正则表达式匹配
 *
 * https://my.oschina.net/liyurong/blog/1648925
 * created by liyurong
 **/
public class Niuke53_1 {
    public static void main(String[] args) {
        System.out.println(match("aaa".toCharArray(),"a.a".toCharArray()));
        System.out.println(match("aaa".toCharArray(),"ab*ac*a".toCharArray()));
        System.out.println(match("".toCharArray(),".*".toCharArray()));
        System.out.println();
        System.out.println(match("aaa".toCharArray(),"aa.a".toCharArray()));
        System.out.println(match("aaa".toCharArray(),"ab*a".toCharArray()));
    }
    public static boolean match(char[] str, char[] pattern){
        if (str == null || pattern == null){
            return false;
        }
        return isMatch(str,0,pattern,0);
    }
    public static boolean isMatch(char[] str,int i,char[] pattern,int j){
        if (i >= str.length && j >= pattern.length){
            return true;
        }
        if (i < str.length && j >= pattern.length){
            return false;
        }
        if (j + 1 < pattern.length && pattern[j + 1] == '*'){
            if (i >= str.length){
                return isMatch(str,i,pattern,j + 2);
            }else {
                if (str[i] == pattern[j] || pattern[j] == '.'){
                    return isMatch(str,i,pattern,j + 2)
                            || isMatch(str,i + 1,pattern,j)
                            || isMatch(str,i + 1,pattern,j + 2);
                }else {
                    return isMatch(str,i,pattern,j + 2);
                }
            }
        }
        if (i >= str.length){
            return false;
        }else {
            if (str[i] == pattern[j] || pattern[j] == '.'){
                return isMatch(str,i + 1,pattern,j + 1);
            }
        }
        return false;
    }
}
