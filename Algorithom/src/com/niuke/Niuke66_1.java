package com.niuke;

/**
 * 矩阵中的路径
 **/
public class Niuke66_1 {
    public static void main(String[] args) {
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str1 = "bcced".toCharArray();
        System.out.println(hasPath(matrix,3,4,str1));
        char[] str2 = "abcb".toCharArray();
        System.out.println(hasPath(matrix,3,4,str2));
    }
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        boolean[] isvisited = new boolean[rows * cols];
        for (int i = 0;i < rows;i ++){//判断以每个位置为起点
            for (int j = 0;j < cols;j ++){
                if (dfs(matrix,rows,cols,str,i,j,0,isvisited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[] matrix,int rows,int cols,char[] str,int i,int j,int k,boolean[] isvisited){
        if (i < 0 || i >= rows || j < 0 || j >= cols || k >= str.length || matrix[i * cols + j] != str[k] || isvisited[i * cols + j]){
            return false;
        }
        if (k == str.length - 1){
            return true;
        }
        isvisited[i * cols + j] = true;
        if (dfs(matrix,rows,cols,str,i - 1,j,k + 1,isvisited)
                || dfs(matrix,rows,cols,str,i + 1,j,k + 1,isvisited)
                || dfs(matrix,rows,cols,str,i,j - 1,k + 1,isvisited)
                || dfs(matrix,rows,cols,str,i,j + 1,k + 1,isvisited)){
            return true;
        }
        isvisited[i * cols + j] = false;//还原，很重要！！！,因为不止一个起点
        return false;
    }
}