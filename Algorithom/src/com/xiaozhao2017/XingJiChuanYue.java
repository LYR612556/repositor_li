package com.xiaozhao2017;

import java.util.Scanner;

/**
 * 网易——星际穿越,注意输入的范围，应该如何保存
 * created by liyurong
 **/
public class XingJiChuanYue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Long h = sc.nextLong();
            long tmp = (long)Math.sqrt(h);
            if (tmp * tmp + tmp <= h){
                System.out.println((int) tmp);
            }else {
                System.out.println((int)(tmp - 1));
            }
        }
        sc.close();
    }
}