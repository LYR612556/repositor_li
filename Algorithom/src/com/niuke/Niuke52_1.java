package com.niuke;

/**
 * 构建乘积数组
 *
 * https://my.oschina.net/liyurong/blog/1648887
 * created by liyurong
 **/
public class Niuke52_1 {
    public static void main(String[] args) {
        int[] A = {1,2,3};
        int[] res = multiply(A);
        for (int i : res){
            System.out.print(i + " ");
        }
    }
    public static int[] multiply(int[] A) {
        if (A == null || A.length <= 1){
            return null;
        }
        int[] res = new int[A.length];
        res[0] = 1;
        for (int i = 1;i < A.length;i ++){
            res[i] = res[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = A.length - 2;i >= 0;i --){
            tmp *= A[i + 1];
            res[i] *= tmp;
        }
        return res;
    }
}