package com.niuke;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的K个数，借助大根堆
 * 博客位置：https://my.oschina.net/liyurong/blog/1632292
 * created by liyurong
 **/
public class Niuke30_2 {
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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1,o2) -> o2-o1);
        for (int i = 0;i < input.length;i ++){
            priorityQueue.offer(input[i]);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        for (int i = 0;i < k;i ++){
            res.add(0,priorityQueue.poll());
        }
        return res;
    }
}