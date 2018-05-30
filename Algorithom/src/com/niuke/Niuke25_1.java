package com.niuke;

import com.source.TreeNode;
import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 博客位置：https://my.oschina.net/liyurong/blog/1539981
 * created by liyurong
 **/
public class Niuke25_1 {
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
        ArrayList<ArrayList<Integer>> res = FindPath(t1,7);
        for (ArrayList<Integer> list : res){
            for (int i = 0;i < list.size();i ++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root,target,list,res);
        return res;
    }
    public static void dfs(TreeNode root,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> res){
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && target == root.val){
            res.add(new ArrayList<>(list));
        }
        dfs(root.left,target - root.val,list,res);
        dfs(root.right,target - root.val,list,res);
        list.remove(list.size() - 1);
    }
}