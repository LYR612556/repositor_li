package com.niuke;

import com.source.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树,层序遍历
 **/
public class Niuke61_1 {
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
        ArrayList<ArrayList<Integer>> res = Print(t1);
        for (ArrayList<Integer> list : res){
            for (Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int level = 0;
        while (! queue.isEmpty()){
            level ++;
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0;i < count;i ++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if ((level & 1) == 0){
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}