package com.xiaozhao2017;

import java.util.Scanner;

/**
 * ���ס�����ƻ��,ֱ�ӽ�����࿼�����
 * ����������֮�ͣ��ܷ�����n������������n�����-1��
 * �����������ֵavg�������飬ÿһ������avg�Ĳ�ֵ�ܷ�����2����������2�����-1 ������
 *
 * created by liyurong
 **/
public class FenPingGuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] A = new int[n];
            int sum = 0;//��¼����ƻ���ĸ���
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