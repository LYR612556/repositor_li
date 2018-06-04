package com.niuke;

import java.util.Arrays;

/**
 * ��������˳��ʹ����λ��ż��ǰ��
 * created by liyurong
 **/
public class Niuke14_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        reOrderArray(array);
        for (int n : array){
            System.out.print(n + " ");
        }
    }
    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0) return;
        int start = 0;
        int end = array.length - 1;
        while (start < end){
            while (start < end && (array[start] & 1) == 1){//����
                start ++;
            }
            while (start < end && (array[end] & 1) == 0){
                end --;
            }
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
        }
        start = 0;
        while (start < end && (array[start] & 1) == 1){
            start ++;
        }
        /**
         * @param fromIndex the index of the first element, inclusive, to be sorted
         * @param toIndex the index of the last element, exclusive, to be sorted
         */
        Arrays.sort(array,0,start);
        Arrays.sort(array,start,array.length);
    }
}