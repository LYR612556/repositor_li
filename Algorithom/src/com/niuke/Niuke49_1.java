package com.niuke;

/**
 * ���üӼ��˳����ӷ�
 * created by liyurong
 **/
public class Niuke49_1 {
    public static void main(String[] args) {
        System.out.println(Add(1,2));
    }
    public static int Add(int num1,int num2) {//���õ�ÿλ��ӣ���õ���λ
        if (num1 == 0) return num2;
        if (num2 == 0) return num1;
        int sum = num1 ^ num2;
        int carry = (num1 & num2) << 1;
        return Add(sum,carry);
    }
}