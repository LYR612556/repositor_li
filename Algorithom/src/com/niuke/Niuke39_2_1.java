package com.niuke;

import com.source.TreeNode;

/**
 * 二叉树的深度
 * created by liyurong
 **/
public class Niuke39_2_1 {
    public static int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }
}
