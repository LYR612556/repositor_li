package com.niuke;

/**
 * 二维数组中的查找,右上角
 * created by liyurong
 **/
public class Niuke3_1 {
    public static void main(String[] args) {
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(7,array));
    }
    public static boolean Find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0) return false;
        int m = array.length;
        int n = array[0].length;
        int i = 0;
        int j = n - 1;
        while (i < m && j >= 0){
            if (array[i][j] == target){
                return true;
            }else if (array[i][j] < target){
                i ++;
            }else {
                j --;
            }
        }
        return false;
    }
}