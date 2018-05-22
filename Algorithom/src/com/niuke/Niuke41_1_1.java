package com.niuke;

import java.util.ArrayList;

/**
 * 和为S的两个数字,两数之和
 * 博客地址：https://my.oschina.net/liyurong/blog/1648178
 * created by liyurong
 **/
public class Niuke41_1_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        ArrayList<Integer> res = FindNumbersWithSum(array,6);
        for (int i = 0;i < res.size();i ++){
            System.out.println(res.get(i));
        }
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int left = 0;
        int right = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (left < right){
            if (array[left] + array[right] == sum){
                res.add(array[left]);
                res.add(array[right]);
                return res;
            } else if (array[left] + array[right] < sum){
                left ++;
            } else {
                right --;
            }
        }
        return res;
    }
}