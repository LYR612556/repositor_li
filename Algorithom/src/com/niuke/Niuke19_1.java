package com.niuke;

import com.source.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树的镜像
 * created by liyurong
 **/
public class Niuke19_1 {
    public void Mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
