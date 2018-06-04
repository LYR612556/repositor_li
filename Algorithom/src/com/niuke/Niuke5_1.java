package com.niuke;

import com.source.TreeNode;

/**
 * 重建二叉树,根据先序和中序
 * created by liyurong
 **/
public class Niuke5_1 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
    }
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return build(pre,0,in,0,in.length - 1);
    }
    public static TreeNode build(int[] pre,int idx,int[] in,int start,int end){
        if (pre == null || in == null || idx >= pre.length || start > end){
            return null;
        }
        int mid = start;
        for (int i = start;i <= end;i ++){
            if (in[i] == pre[idx]){
                mid = i;
                break;
            }
        }
        int llen = mid - start;
        int rlen = end - mid;
        TreeNode root = new TreeNode(pre[idx]);
        root.left = build(pre,idx + 1,in,start,mid - 1);
        root.right = build(pre,idx + llen + 1,in,mid + 1,mid + rlen);
        return root;
    }
}