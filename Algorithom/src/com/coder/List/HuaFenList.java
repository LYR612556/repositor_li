package com.coder.List;

import com.source.ListNode;

/**
 * 类似于快排的划分
 * created by liyurong
 **/
public class HuaFenList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = partitionList(l1,3);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode partitionList(ListNode head,int pivot){
        ListNode small = null;
        ListNode equal = null;
        ListNode big = null;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode p3 = null;
        while (head != null){
            if (head.val < pivot){
                if (small == null){
                    small = head;
                    p1 = head;
                }else {
                    p1.next = head;
                    p1 = head;
                }
            }else if (head.val == pivot){
                if (equal == null){
                    equal = head;
                    p2 = head;
                }else {
                    p2.next = head;
                    p2 = head;
                }
            }else {
                if (big == null){
                    big = head;
                    p3 = head;
                }else {
                    p3.next = head;
                    p3 = head;
                }
            }
            head = head.next;
        }
        if (p1 != null){
            p1.next = equal;
            p2 = p2 == null ? p1 : p2;
        }
        if (p2 != null){
            p2.next = big;
        }
        return small != null ? small : equal != null ? equal : big;
    }
}