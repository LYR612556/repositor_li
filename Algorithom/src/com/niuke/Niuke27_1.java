package com.niuke;

import com.source.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 博客位置：https://my.oschina.net/liyurong/blog/1631592
 * created by liyurong
 **/
public class Niuke27_1 {
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
        TreeNode res = Convert(t1);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.right;
        }
    }
    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode[] pLast = new TreeNode[1];
        Convert(pRootOfTree,pLast);
        TreeNode head = pLast[0];
        while (head != null && head.left != null){
            head = head.left;
        }
        return head;
    }
    public static void Convert(TreeNode pRootOfTree,TreeNode[] pLast){
        if (pRootOfTree != null){
            if (pRootOfTree.left != null){
                Convert(pRootOfTree.left,pLast);
            }
            pRootOfTree.left = pLast[0];
            if (pLast[0] != null){
                pLast[0].right = pRootOfTree;
            }
            pLast[0] = pRootOfTree;
            if (pRootOfTree.right != null){
                Convert(pRootOfTree.right,pLast);
            }
        }
    }
}