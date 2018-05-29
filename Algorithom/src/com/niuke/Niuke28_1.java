package com.niuke;

import java.util.ArrayList;

/**
 * 字符串的排列
 * 博客位置：https://my.oschina.net/liyurong/blog/1528710
 * created by liyurong
 **/
public class Niuke28_1 {
    public static void main(String[] args) {
        ArrayList<String> res = Permutation("abc");
        for (String str : res){
            System.out.print(str + " ");
        }
    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] schar = str.toCharArray();
        boolean[] isvisited = new boolean[schar.length];
        dfs(schar,isvisited,"",res);
        return res;
    }
    public static void dfs(char[] schar,boolean[] isvisited,String curStr,ArrayList<String> res){
        if (curStr.length() == schar.length){
            if (! res.contains(curStr)){
                res.add(curStr);
            }
            return;
        }
        for (int i = 0;i < schar.length;i ++){
            if (! isvisited[i]){
                curStr += schar[i];
                isvisited[i] = true;
                dfs(schar,isvisited,curStr,res);
                curStr = curStr.substring(0,curStr.length() - 1);
                isvisited[i] = false;
            }
        }
    }
}