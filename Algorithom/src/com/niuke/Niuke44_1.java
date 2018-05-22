package com.niuke;

import java.util.Arrays;

/**
 * 扑克牌顺子
 * 博客地址：https://my.oschina.net/liyurong/blog/1648766
 * created by liyurong
 **/
public class Niuke46_1 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,2,6,4};
        System.out.println(isContinuous(nums1));
        int[] nums2 = {1,3,2,5,4};
        System.out.println(isContinuous(nums2));
        int[] nums3 = {1,3,2,0,4};
        System.out.println(isContinuous(nums3));
    }
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5){
            return false;
        }
        Arrays.sort(numbers);
        int zeroCount = 0;
        int i = 0;
        while (i < 5 && numbers[i] == 0){
            zeroCount ++;
            i ++;
        }
        int j = i + 1;
        int count = 0;//缺少的个数
        while (j < 5){
            if (numbers[i] == numbers[j]){
                return false;
            }
            count += numbers[j] - numbers[i] - 1;
            if (count > zeroCount) return false;
            i ++;
            j ++;
        }
        return true;
    }
}