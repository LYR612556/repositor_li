package com.coder.StackAndQueue;

import com.niuke.Niuke23_1;
import com.source.TreeLinkNode;
import com.source.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 构造数组的MaxTree,时间O（n），空间O（n）
 * created by liyurong
 **/
public class MaxTree {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        TreeNode root = getMaxTree(arr);
        ArrayList<Integer> res = Niuke23_1.PrintFromTopToBottom(root);
        System.out.println(res.toString());
    }
    public static TreeNode getMaxTree(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        TreeNode[] nodeArr = new TreeNode[arr.length];
        for (int i = 0;i < arr.length;i ++){//封装数组
            nodeArr[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<>();//辅助获取最大值
        HashMap<TreeNode,TreeNode> leftBigger = new HashMap<>();
        HashMap<TreeNode,TreeNode> rightBigger = new HashMap<>();
        //获取左侧较大值
        for (int i = 0;i < nodeArr.length;i ++){
            TreeNode cur = nodeArr[i];
            while (! stack.isEmpty() && stack.peek().val < cur.val){
                //由下到上降序排列stack，若有不符合规则的，弹出，并更新map
                popStackSetMap(stack,leftBigger);
            }
            stack.push(cur);
        }
        while (! stack.isEmpty()){
            popStackSetMap(stack,leftBigger);
        }

        //获取右侧较大值
        for (int i = nodeArr.length - 1;i >= 0;i --){
            TreeNode cur = nodeArr[i];
            while (! stack.isEmpty() && stack.peek().val < cur.val){
                popStackSetMap(stack,rightBigger);
            }
            stack.push(cur);
        }
        while (! stack.isEmpty()){
            popStackSetMap(stack,rightBigger);
        }

        //构造最大树
        TreeNode root = null;
        for (int i = 0;i < nodeArr.length;i ++){
            TreeNode cur = nodeArr[i];
            TreeNode left  = leftBigger.get(cur);
            TreeNode right = rightBigger.get(cur);
            if (left == null && right == null){//数组中的最大值为根节点
                root = cur;
            }else if (left == null){
                if (right.left == null){
                    right.left = cur;
                }else {
                    right.right = cur;
                }
            }else if (right == null){
                if (left.left == null){
                    left.left = cur;
                }else {
                    left.right = cur;
                }
            }else {
                TreeNode parent = left.val < right.val ? left : right;//左右两侧最大值的较小值为父节点
                if (parent.left == null){
                    parent.left = cur;
                }else {
                    parent.right = cur;
                }
            }
        }
        return root;
    }
    public static void popStackSetMap(Stack<TreeNode> stack, HashMap<TreeNode,TreeNode> map){
        TreeNode popNode = stack.pop();
        if (stack.isEmpty()){
            map.put(popNode,null);
        }else {
            map.put(popNode,stack.peek());
        }
    }
}