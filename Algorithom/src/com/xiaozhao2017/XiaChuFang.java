package com.xiaozhao2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ���ס����³���,ֱ��
 * created by liyurong
 **/
public class XiaChuFang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while (sc.hasNext()){//ע������
            set.add(sc.next());
        }
        System.out.println(set.size());
        sc.close();
    }
}