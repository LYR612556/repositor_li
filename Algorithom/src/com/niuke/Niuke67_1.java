package com.niuke;

/**
 * 机器人运动范围，使用二维数组
 **/
public class Niuke67_1 {
    public static void main(String[] args) {
        int res = movingCount(18,40,40);//350,   18,40,40---> 1484
        System.out.println(res);
    }
    public static int movingCount(int threshold, int rows, int cols){
        boolean[][] isvisited = new boolean[rows][cols];
        int count = dfs(threshold,0,0,rows,cols,isvisited);
        return count;
    }
    public static int dfs(int thresold,int i,int j,int rows,int cols,boolean[][] isvisited){
        int count = 0;//尽量不要使用全局变量，OJ中结果不正确
        if (canMove(thresold,i,j,rows,cols,isvisited)){
            count ++;
            isvisited[i][j] = true;
            count += dfs(thresold,i - 1,j,rows,cols,isvisited);
            count += dfs(thresold,i + 1,j,rows,cols,isvisited);
            count += dfs(thresold,i,j - 1,rows,cols,isvisited);
            count += dfs(thresold,i,j + 1,rows,cols,isvisited);
        }
        return count;
    }
    public static boolean canMove(int threshold,int i,int j,int rows,int cols,boolean[][] isvisited){
        if (i >=0 && j >= 0 && i < rows && j < cols && ! isvisited[i][j] && getDigits(i) + getDigits(j) <= threshold){
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