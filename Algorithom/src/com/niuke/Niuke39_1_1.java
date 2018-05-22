package com.niuke;

import com.source.TreeNode;

/**
 * 平衡二叉树
 * 博客地址：https://my.oschina.net/liyurong/blog/1506393
 * created by liyurong
 **/
public class Niuke39_1_1 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(IsBalanced_Solution(t1));
    }
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int ldept = getDepth(root.left);
        int rdept = getDepth(root.right);
        if (Math.abs(ldept - rdept) > 1){
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
    public static int getDepth(TreeNode root){
        if (root == null) return 0;
        int ldepth = getDepth(root.left);
        int rdepth = getDepth(root.right);
        return Math.max(ldepth,rdepth) + 1;
    }
}