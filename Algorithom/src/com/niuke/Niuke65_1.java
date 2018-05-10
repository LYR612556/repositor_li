package com.niuke;

import java.util.ArrayList;

/**
 * 滑动窗口的最大值,使用标记记录最大值的下标
 **/
public class Niuke65_1 {
    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(num,3).toString());
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0){
            return res;
        }
        int maxIndex = 0;
        for (int i = 0;i < size;i ++){
            if (num[i] > num[maxIndex]){
                maxIndex = i;
            }
        }
        res.add(num[maxIndex]);
        for (int i = size;i < num.length;i ++){
            if (Math.abs(i - maxIndex) >= size){
                maxIndex = i - size + 1;
                if (maxIndex + size == num.length){
                    for (int j = maxIndex + 1;j < num.length;j ++){
                        if (num[j] > num[maxIndex]){
                            maxIndex = j;
                        }
                    }
                }
            }
            if (num[i] > num[maxIndex]){
                maxIndex = i;
            }
            res.add(num[maxIndex]);
        }
        return res;
    }
}