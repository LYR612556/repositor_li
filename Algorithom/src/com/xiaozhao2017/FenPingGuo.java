package com.xiaozhao2017;

import java.util.Scanner;

/**
 * 网易——分苹果,直接解决，多考虑情况
 * 求所有数据之和，能否整除n，若不能整除n，输出-1，
 * 能整除，求均值avg遍历数组，每一个数和avg的差值能否整除2，不能整除2，输出-1 结束。
 *
 * created by liyurong
 **/
public class FenPingGuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] A = new int[n];
            int sum = 0;//记录所有苹果的个数
            boolean canAlloc = true;
            for (int i = 0;i < n;i ++){
                A[i] = sc.nextInt();
                sum += A[i];
            }
            int average = sum / n;
            int count = 0;
            if (sum % n == 0){
                for (int i = 0;i < n;i ++){
                    if ((Math.abs(A[i] - average)) % 2 != 0){
                        canAlloc = false;
                    }else if (A[i] > average){
                        count += (A[i] - average) / 2;
                    }
                }
            }else {
                canAlloc = false;
            }

            if (! canAlloc){
                System.out.println(-1);
            }else {
                System.out.println(count);
            }

        }
        sc.close();
    }
}