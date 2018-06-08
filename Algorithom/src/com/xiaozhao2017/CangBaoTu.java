package com.xiaozhao2017;

import java.util.Scanner;

/**
 * 网易——藏宝图,子序列问题,按照在s中的顺序
 * 双指针
 * created by liyurong
 **/
public class CangBaoTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.next();
            String t = sc.next();
            String res = isSubSeq(s.toCharArray(),t.toCharArray());
            System.out.println(res);
        }
        sc.close();
    }
    public static String isSubSeq(char[] schar,char[] tchar){
        if (tchar == null) return "Yes";
        if (schar == null) return "No";
        int len1 = schar.length;
        int len2 = tchar.length;
        if (len1 < len2) return "No";

        int p1 = 0;
        int p2 = 0;
        while (p1 < len1 && p2 < len2){
            if (schar[p1] == tchar[p2]){
                p2 ++;
            }
            p1 ++;
        }
        if (p2 == len2){
            return "Yes";
        }else {
            return "No";
        }
    }
}