package com.niuke;

/**
 * ��������1�ĸ���
 * created by liyurong
 **/
public class Niuke12_1 {
    public static void main(String[] args) {
        System.out.println(NumberOf1(11));
        System.out.println(NumberOf1(5));
    }
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }
}