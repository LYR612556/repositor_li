package com.niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组中的重复数字
 *
 * created by liyurong
 **/
public class Niuke51_1 {
    public static void main(String[] args) {
        int[] num = {2,3,1,0,2,5,3};
        int[] dup = new int[1];
        System.out.println(duplicate(num,7,dup));
    }
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0;i < length;i ++){
            if (set.contains(numbers[i])){
                duplication[0] = numbers[i];
                System.out.println(duplication[0]);
                return true;
            }
            set.add(numbers[i]);
        }
        return false;
    }
}