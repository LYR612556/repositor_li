package com.niuke;

/**
 * 数字在排序数组中出现的次数
 * created by liyurong
 **/
public class Niuke38_1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5};
        System.out.println(GetNumberOfK(arr,3));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for (int i = 0;i < array.length;i ++){
            if (array[i] == k){
                count ++;
            }else if (array[i] > k){
                return count;
            }
        }
        return count;
    }
}