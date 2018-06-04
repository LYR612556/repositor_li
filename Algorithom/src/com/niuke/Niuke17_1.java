package com.niuke;

import com.source.ListNode;

/**
 * 合并两个排序的链表
 * created by liyurong
 **/
public class Niuke17_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode ll1 = new ListNode(2);
        ListNode ll2 = new ListNode(4);
        ListNode ll3 = new ListNode(5);
        ListNode ll4 = new ListNode(7);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;

        ListNode res = Merge(l1,ll1);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }

    }
    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                p.next = list1;
                list1 = list1.next;
            }else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null){
            p.next = list1;
        }
        if (list2 != null){
            p.next = list2;
        }
        return head.next;
    }
}