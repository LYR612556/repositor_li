package com.niuke;

import com.source.TreeNode;

import java.util.ArrayList;

/**
 * ¶þ²æÊ÷µÄ¾µÏñ
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