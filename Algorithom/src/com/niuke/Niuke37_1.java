package com.niuke;

import com.source.ListNode;

/**
 * 两个链表的第一个公共结点
 * 博客位置：https://my.oschina.net/liyurong/blog/994540
 * created by liyurong
 **/
public class Niuke37_1 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        l1.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l2.next = l3;
        ListNode res = FindFirstCommonNode(l1,l2);
        System.out.println(res.val);
    }
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = 1;
        int len2 = 1;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1.next != null) {
            p1 = p1.next;
            len1 ++;
        }
        while (p2.next != null){
            p2 = p2.next;
            len2 ++;
        }
        if (p1 != p2){
            return null;
        }
        p1 = pHead1;
        p2 = pHead2;
        while (len1 > len2){
            p1 = p1.next;
            len1 --;
        }
        while (len1 < len2){
            p2 = p2.next;
            len2 --;
        }
        while (p1.val != p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}