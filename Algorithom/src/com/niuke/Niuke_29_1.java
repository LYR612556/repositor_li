package com.niuke;

/**
 * �����г��ִ�������һ�������,���������ص㣬�����г���һ��������϶���������������������
 * ����λ�ã�https://my.oschina.net/liyurong/blog/915707�����е��ƾٷ��������⣬Ӧʹ�ñ���Ľⷨ
 * �����д���n/3������https://my.oschina.net/liyurong/blog/1591542
 * created by liyurong
 **/
public class Niuke_29_1 {
    public static void main(String[] args){
        //int[] numbers = {1,2,3,2,4,2,5,2,3};//0
        //int[] numbers = {1,2,3,2,4,2,5,2,2};//2
        int[] numbers = {4,2,4,1,4,2};//0
        int res = MoreThanHalfNum_Solution(numbers);
        System.out.println(res);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int majority = 0;
        int count = 0;
        for (int i = 0;i < array.length;i ++){
            if (count == 0){
                majority = array[i];
                count ++;
            }else if (array[i] == majority){
                count ++;
            }else {
                count --;
            }
        }
        //�ж��Ƿ���������һ��
        count = 0;
        for (int i = 0;i < array.length;i ++){
            if (array[i] == majority){
                count ++;
            }
        }
        if (count <= array.length / 2){
            return 0;
        }
        return majority;
    }
}