package com.xiaozhao2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 网易——下厨房,直接
 * created by liyurong
 **/
public class XiaChuFang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNext()){//注意输入
            set.add(sc.next());
        }
        System.out.println(set.size());
        sc.close();
    }
}