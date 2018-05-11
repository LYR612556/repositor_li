package com.niuke;

import com.source.TreeNode;
import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * ¶Ô³Æ¶þ²æÊ÷
 **/
public class Niuke59_1 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        boolean res = isSymmetrical(t1);
        System.out.println(res);
    }
    public static boolean isSymmetrical(TreeNode pRoot){
        if (pRoot == null) return true;
        return isSame(pRoot.left,pRoot.right);
    }
    public static boolean isSame(TreeNode left,TreeNode right){
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSame(left.left,right.right) && isSame(left.right,right.left);
    }
}