package com.niuke;

import com.source.TreeNode;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k个节点，中序遍历第k个
 **/
public class Niuke63_1 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode res = KthNode(t1,3);
        System.out.println(res.val);
    }
    public static TreeNode KthNode(TreeNode pRoot, int k){
        if (k == 0) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        inorder(pRoot,list);
        if (k > list.size()) return null;
        return list.get(k - 1);
    }
    public static void inorder(TreeNode root,ArrayList<TreeNode> list){
        if (root == null) return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}