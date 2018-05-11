package com.niuke;

import java.util.PriorityQueue;
/**
 * 数据流中的中位数,借助大根堆和小根堆获取中间的两个数
 **/
public class Niuke64_1 {
    public static void main(String[] args) {
        Insert(5);
        System.out.print(GetMedian() + " ");
        Insert(2);
        System.out.print(GetMedian() + " ");
        Insert(3);
        System.out.print(GetMedian() + " ");
        Insert(4);
        System.out.print(GetMedian() + " ");
        Insert(1);
        System.out.print(GetMedian() + " ");
        Insert(6);
        System.out.print(GetMedian() + " ");
        Insert(7);
        System.out.print(GetMedian() + " ");
        Insert(0);
        System.out.print(GetMedian() + " ");
        Insert(8);
        System.out.print(GetMedian() + " ");
    }
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2)->o1 - o2);
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2)->o2 - o1);
    static int count = 0;
    public static void Insert(Integer num) {
        if (count % 2 == 0){
            maxHeap.offer(num);
            int maxVal = maxHeap.poll();
            minHeap.offer(maxVal);
        }else {
            minHeap.offer(num);
            int minVal = minHeap.poll();
            maxHeap.offer(minVal);
        }
        count ++;
    }
    public static Double GetMedian() {
        if (count % 2 == 1){
            return new Double(minHeap.peek());
        }else {
            int minVal = minHeap.peek();
            int maxVal = maxHeap.peek();
            return (minVal + maxVal) / 2.0;
        }
    }
}