package com.niuke;

/**
 * 机器人的运动范围，使用一维数组
 **/
public class Niuke67_2 {
    public static void main(String[] args) {
        int res = movingCount(10,1,10);
        System.out.println(res);
    }
    public static int movingCount(int threshold, int rows, int cols){
        boolean[] isvisited = new boolean[rows * cols];
        int res = dfs(threshold,rows,cols,0,0,isvisited);
        return res;
    }
    public static int dfs(int threshold,int rows,int cols,int i,int j,boolean[] isvisited){
        int count = 0;
        if (canMove(threshold,rows,cols,i,j,isvisited)){
            isvisited[i * cols + j] = true;
            count = 1 + dfs(threshold,rows,cols,i - 1,j,isvisited)
                    + dfs(threshold,rows,cols,i + 1,j,isvisited)
                    + dfs(threshold,rows,cols,i,j - 1,isvisited)
                    + dfs(threshold,rows,cols,i,j + 1,isvisited);
        }
        return count;
    }
    public static boolean canMove(int threshold,int rows,int cols,int i,int j,boolean[] isvisited){
        if (i >= 0 && i < rows && j >= 0 && j < cols && ! isvisited[i * cols + j] && getDigits(i) + getDigits(j) <= threshold){
            return true;
        }
        return false;
    }
    public static int getDigits(int num){
        int sum = 0;
        while (num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}