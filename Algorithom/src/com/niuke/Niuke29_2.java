package com.niuke;

/**
 * 数组中出现次数超过一半的数，找中位数
 * 博客位置：https://my.oschina.net/liyurong/blog/1632043
 * created by liyurong
 **/
public class Niuke29_2 {
    public static void main(String[] args) {
        int[] numbers = {4,2,4,1,4,2};//0
        System.out.println(MoreThanHalfNum_Solution(numbers));
        int[] numbers1 = {1,2,3,2,4,2,5,2,3};//0
        System.out.println(MoreThanHalfNum_Solution(numbers1));
        int[] numbers2 = {1,2,3,2,2,2,5,4,2};//2
        System.out.println(MoreThanHalfNum_Solution(numbers2));
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        int len = array.length;
        int start = 0;
        int end = len - 1;
        int index = partition(array,start,end);
        while (index != len / 2){
            if (index > len / 2){
                end = index - 1;
                index = partition(array,start,end);
            }else {
                start = index + 1;
                index = partition(array,start,end);
            }
        }
        int count = 0;
        for (int i = 0;i < array.length;i ++){
            if (array[i] == array[index]){
                count ++;
            }
        }
        if (count <= len / 2){
            return 0;
        }
        return array[index];
    }
    public static int partition(int[] array,int start,int end){
        int pivot = array[start];
        if (start < end){
            while (start < end && array[end] >= pivot){
                end --;
            }
            array[start] = array[end];
            while (start < end && array[start] <= pivot){
                start ++;
            }
            array[end] = array[start];
        }
        array[start] = pivot;
        return start;
    }
}