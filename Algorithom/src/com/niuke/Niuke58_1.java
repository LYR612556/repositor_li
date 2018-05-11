package com.niuke;

import com.source.TreeLinkNode;

/**
 * 二叉树的下一个节点
 **/
public class Niuke58_1 {
    public static void main(String[] args) {
        TreeLinkNode t1 = new TreeLinkNode(1);
        TreeLinkNode t2 = new TreeLinkNode(2);
        TreeLinkNode t3 = new TreeLinkNode(3);
        TreeLinkNode t4 = new TreeLinkNode(4);
        TreeLinkNode t5 = new TreeLinkNode(5);
        TreeLinkNode t6 = new TreeLinkNode(6);
        TreeLinkNode t7 = new TreeLinkNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.next = t1;
        t3.next = t1;
        t2.left = t4;
        t2.right = t5;
        t4.next = t2;
        t5.next = t2;
        t3.left = t6;
        t3.right = t7;
        t6.next = t3;
        t7.next = t3;
        System.out.println(GetNext(t4).val);
        System.out.println(GetNext(t5).val);
        System.out.println(GetNext(t3).val);
    }
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null){
            return null;
        }
        TreeLinkNode target = null;
        TreeLinkNode cur = pNode;
        if (cur.right != null){
            target = cur.right;
            while (target.left != null){
                target = target.left;
            }
            return target;
        }
        if (cur.next == null) return null;
        if (cur.next.left == cur){
            return cur.next;
        }
        target = cur.next;
        while (target.next != null){
            if (target == target.next.left){
                return target.next;
            }
            target = target.next;
        }
        return null;
    }
}