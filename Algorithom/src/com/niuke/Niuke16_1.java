package com.niuke;

import com.source.ListNode;

/**
 * ·´×ªÁ´±í
 * created by liyurong
 **/
public class Niuke16_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode res = ReverseList(l1);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode phead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = phead.next;
            phead.next = cur;
            cur = next;
        }
        return phead.next;
    }
}