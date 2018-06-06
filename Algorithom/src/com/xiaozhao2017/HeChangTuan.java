package com.xiaozhao2017;

import java.util.*;

/**
 * ����2017�����ϳ���,��̬�滮
 * ����λ�ã�https://my.oschina.net/liyurong/blog/1825050
 * created by liyurong
 **/
public class HeChangTuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();//ѧ������
            int[] ability = new int[n + 1];
            for (int i = 1;i <= n;i ++){
                ability[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int d = sc.nextInt();

            long[][] max = new long[k + 1][n + 1];//max[k][n]��ʾ��nΪֹk��ѧ�������˻�
            long[][] min = new long[k + 1][n + 1];

            long multi = Long.MIN_VALUE;
            for (int i = 1;i <= n;i ++){
                max[1][i] = ability[i];
                min[1][i] = ability[i];
                for (int j = 2;j <= k;j ++){
                    for (int pre = i - 1;pre > 0 && i - pre <= d;pre --){
                        max[j][i] = Math.max(max[j][i],Math.max(max[j - 1][pre] * ability[i],min[j - 1][pre] * ability[i]));
                        min[j][i] = Math.min(min[j][i],Math.min(max[j - 1][pre] * ability[i],min[j - 1][pre] * ability[i]));
                    }
                }
                multi = Math.max(multi,max[k][i]);//����ÿһ������k��ѧ�������ֵ��ȡ����
            }
            System.out.println(multi);
        }
    }
}