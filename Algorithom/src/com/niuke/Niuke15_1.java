package com.niuke;

import com.source.ListNode;

/**
 * 链表中倒数第k个结点
 * created by liyurong
 **/
public class Niuke15_1 {
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
        System.out.println(FindKthToTail(l1,4).val);
    }
    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0;i < k;i ++){
            if (fast.next != null){
                fast = fast.next;
            }else {
                return null;
            }
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}