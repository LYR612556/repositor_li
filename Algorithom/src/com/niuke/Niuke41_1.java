package com.niuke;

/**
 * 数组中只出现一次的数字
 * 博客地址：https://my.oschina.net/liyurong/blog/1648132
 * created by liyurong
 **/
public class Niuke41_1 {
    public static void main(String[] args) {
        int[] array = {1,1,2,2,3,4,4,5};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        FindNumsAppearOnce(array,num1,num2);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2){
            return;
        }
        int xor = 0;
        for (int i = 0;i < array.length;i ++){
            xor ^= array[i];
        }
        int index = findOne(xor);
        for (int i = 0;i < array.length;i ++){
            if (isOne(array[i],index)){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
    public static int findOne(int n){
        int index = 0;
        while ((n & 1) == 0 && index < 32){
            n >>>= 1;
            index ++;
        }
        return index;
    }
    public static boolean isOne(int n,int index){
        n = n >> index;
        return (n & 1) == 1;
    }
}