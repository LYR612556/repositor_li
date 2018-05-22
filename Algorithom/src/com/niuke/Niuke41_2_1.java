package com.niuke;

import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 博客地址：https://my.oschina.net/liyurong/blog/1648172
 * created by liyurong
 **/
public class Niuke40_1 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = FindContinuousSequence(100);
        for (int i = 0;i < res.size();i ++){
            for (int j = 0;j < res.get(i).size();j ++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum < 3) return res;
        int p1 = 1;
        int p2 = 2;
        int cursum = p1 + p2;
        int end = (sum + 1) / 2;
        while (p2 <= end){
            if (cursum == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = p1;i <= p2;i ++){
                    list.add(i);
                }
                res.add(list);
            }
            while (cursum > sum && p1 < p2){
                cursum -= p1;
                p1 ++;
                if (cursum == sum){
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = p1;i <= p2;i ++){
                        list.add(i);
                    }
                    res.add(list);
                }
            }
            p2 ++;
            cursum += p2;
        }
        return res;
    }
}