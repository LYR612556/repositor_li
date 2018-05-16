package com.niuke;

import com.source.ListNode;

/**
 * 删除链表中的重复节点
 * 博客地址：https://my.oschina.net/liyurong/blog/1649023
 * created by liyurong
 **/
public class Niuke57_1 {
    public static void main(String[] args) {//1,1,1,1,1,1   1,2,3,3,3,4,4,5
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l33 = new ListNode(3);
        ListNode l333 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l44 = new ListNode(4);
        ListNode l5= new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l33;
        l33.next = l333;
        l333.next = l4;
        l4.next = l44;
        l44.next = l5;
        ListNode res = deleteDuplication(l1);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null || pHead.next == null) return pHead;
        ListNode p = new ListNode(-1);
        ListNode pre = p;
        p.next = pHead;
        ListNode cur = pHead;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return p.next;
    }
}