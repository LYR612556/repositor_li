package com.coder.StackAndQueue;

import com.niuke.Niuke23_1;
import com.source.TreeLinkNode;
import com.source.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * ���������MaxTree,ʱ��O��n�����ռ�O��n��
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
        for (int i = 0;i < arr.length;i ++){//��װ����
            nodeArr[i] = new TreeNode(arr[i]);
        }
        Stack<TreeNode> stack = new Stack<>();//������ȡ���ֵ
        HashMap<TreeNode,TreeNode> leftBigger = new HashMap<>();
        HashMap<TreeNode,TreeNode> rightBigger = new HashMap<>();
        //��ȡ���ϴ�ֵ
        for (int i = 0;i < nodeArr.length;i ++){
            TreeNode cur = nodeArr[i];
            while (! stack.isEmpty() && stack.peek().val < cur.val){
                //���µ��Ͻ�������stack�����в����Ϲ���ģ�������������map
                popStackSetMap(stack,leftBigger);
            }
            stack.push(cur);
        }
        while (! stack.isEmpty()){
            popStackSetMap(stack,leftBigger);
        }

        //��ȡ�Ҳ�ϴ�ֵ
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

        //���������
        TreeNode root = null;
        for (int i = 0;i < nodeArr.length;i ++){
            TreeNode cur = nodeArr[i];
            TreeNode left  = leftBigger.get(cur);
            TreeNode right = rightBigger.get(cur);
            if (left == null && right == null){//�����е����ֵΪ���ڵ�
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
                TreeNode parent = left.val < right.val ? left : right;//�����������ֵ�Ľ�СֵΪ���ڵ�
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