package com.xiaozhao2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * ���ס���������ϣ���ѧ���⣬��������
 * created by liyurong
 **/
/**
 * 15
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 */
public class HunHeYanLiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            ArrayList<Integer> needs = new ArrayList<>();
            for (int i = 0;i < n;i ++){
                needs.add(sc.nextInt());
            }

            int minColor = getMinColor(needs);
            System.out.println(minColor);
        }
        sc.close();
    }
    //��ȡ�������
    public static int getMinColor(ArrayList<Integer> needs){
        int count = 0;
        Collections.sort(needs);
        //ʹ������ָ��ָ����������
        int end = needs.size() - 1;
        int secend = end - 1;
        while (needs.size() > 2){
            //�����ߵ����λ��ͬ��˵������������������xor������˵��������������������λ
            if (getHighPosition(needs.get(end)) == getHighPosition(needs.get(secend))){
                //����xor�����������������������λ�Ѿ�������������xor�õ��Ľ��һ������������С
                int tmp = needs.get(end) ^ needs.get(secend);
                if (! needs.contains(tmp)){
                    needs.add(tmp);
                    end ++;
                    secend ++;
                    Collections.sort(needs);
                }
            }else {
                //�����ߵĸ�λ��ͬ��˵�������������λ�Ѿ�ֻ�������Ǹ�����1�ˣ������ܱ����������+1
                count ++;
            }
            //�����������������λ������������ô����֮��������Ѿ�������û������
            //�����������������λ��������������ô���+1�������Ҳû������
            //���������
            needs.remove(needs.size() - 1);
            //����ָ��
            end = secend;
            secend --;
        }
        return needs.size() + count;
    }
    //��������λ�ǵڼ�λ
    public static int getHighPosition(int n){
        int count = 0;
        while (n != 0){
            n >>= 1;
            count ++;
        }
        return count;
    }
}