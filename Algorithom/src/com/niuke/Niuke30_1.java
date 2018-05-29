package com.niuke;

import java.util.ArrayList;

/**
 * 最小的K个数,借助快排,前k个数会无序
 * 博客位置：https://my.oschina.net/liyurong/blog/1632292
 * created by liyurong
 **/
public class Niuke30_1 {
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(input,4);
        for (int n : res){
            System.out.print(n + " ");
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || input.length < k){
            return res;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);
        while (index != k - 1){
            if (index > k - 1){
                end = index - 1;
                index = partition(input,start,end);
            }else {
                start = index + 1;
                index = partition(input,start,end);
            }
        }
        for (int i = 0;i < k;i ++){
            res.add(input[i]);
        }
        return res;
    }
    public static int partition(int[] input,int start,int end){
        int pivot = input[start];
        while (start < end){
            while (start < end && input[end] >= pivot){
                end --;
            }
            input[start] = input[end];
            while (start < end && input[start] <= pivot){
                start ++;
            }
            input[end] = input[start];
        }
        input[start] = pivot;
        return start;
    }
}