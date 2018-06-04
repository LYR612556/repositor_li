package com.niuke;

/**
 * 二叉搜索树的后序遍历序列
 * 博客位置：https://my.oschina.net/liyurong/blog/1631559
 * created by liyurong
 **/
public class Niuke24_1 {
    public static void main(String[] args) {
        int[] sequence = {3,4,6,5,8,10,9,12,11,7};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence,0,sequence.length - 1);
    }
    public static boolean VerifySquenceOfBST(int[] sequence,int start,int end){
        if (start >= end) return true;
        int i = start;
        while (i < end - 1 && sequence[i] < sequence[end]){
            i ++;
        }
        int j = i;
        while (j < end - 1 && sequence[j] > sequence[end]){
            j ++;
        }
        if (j != end - 1){
            return false;
        }
        return VerifySquenceOfBST(sequence,start,i - 1) && VerifySquenceOfBST(sequence,i,end - 1);
    }
}