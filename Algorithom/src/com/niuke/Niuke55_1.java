package com.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * �ַ����е�һ�����ظ����ַ�,!!!!!!!һ����Ҫ��static���е�OJ��ͨ��������ţ��
 * https://my.oschina.net/liyurong/blog/1648986
 * created by liyurong
 **/
public class Niuke55_1 {//helloworld
    public static void main(String[] args) {
        Insert('h');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('w');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('r');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('d');
        System.out.println(FirstAppearingOnce());
    }
    static int[] hash = new int[256];
    static List<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public static void Insert(char ch) {
        hash[ch] ++;
        if (hash[ch] == 1){
            list.add(ch);
        }else {
            list.remove((Character) ch);
        }
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        if (list.size() == 0){
            return '#';
        }else {
            return list.get(0);
        }
    }
}