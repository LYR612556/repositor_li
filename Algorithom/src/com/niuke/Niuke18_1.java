package com.niuke;

import com.source.TreeNode;

/**
 * 树的子结构
 * created by liyurong
 **/
public class Niuke18_1 {
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
        System.out.println(HasSubtree(t1,t2));
    }
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public static boolean isSame(TreeNode root1,TreeNode root2){
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;
        boolean left = isSame(root1.left,root2.left);
        boolean right = isSame(root1.right,root2.right);
        return left && right;
    }
}
