package com.niuke;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * created by liyurong
 **/
public class Niuke20_1 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> res = printMatrix(matrix);
        for (int n : res){
            System.out.print(n + " ");
        }
        System.out.println();
        int[][] m = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> r = printMatrix(m);
        for (int n : r){
            System.out.print(n + " ");
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int down = matrix.length - 1;
        while (left <= right && top <= down){
            for (int i = left;i <= right;i ++){
                res.add(matrix[top][i]);
            }
            for (int i = top + 1;i <= down;i ++){
                res.add(matrix[i][right]);
            }
            if (top != down){//注意此处的判断！！！
                for (int i = right - 1;i >= left;i --){
                    res.add(matrix[down][i]);
                }
            }
            if (left != right){
                for (int i = down - 1;i >= top + 1;i --){
                    res.add(matrix[i][left]);
                }
            }
            left ++;
            top ++;
            right --;
            down --;
        }
        return res;
    }
}