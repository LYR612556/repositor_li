package com.niuke;

/**
 * 旋转数组的最小数字
 * created by liyurong
 **/
public class Niuke7_1 {
    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end){
            int mid = (end - start) / 2 + start;
            if (array[mid] == array[start] && array[mid] == array[end]){
                return findMin(array,start,end);
            }
            if (array[mid] >= array[start]){
                start = mid;
            }else {
                end = mid;
            }
        }
        return array[end];
    }
    public static int findMin(int[] array,int start,int end){
        int min = array[start];
        for (int i = start + 1;i <= end;i ++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}