package com.niuke;

/**
 * 连续子数组的最大和
 * created by liyurong
 **/
public class Niuke31_1 {
    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
    }
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < array.length;i ++){
            sum += array[i];
            if (max < sum){
                max = sum;
            }
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
