package com.coder.List;

import com.source.ListNode;

/**
 * 判断链表是否是回文结构
 * created by liyurong
 **/
public class isPalidrome {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        System.out.println("true " + isPalidrome(l1));
        l6 = new ListNode(1);
        System.out.println("false " + isPalidrome(l1));
    }
    public static boolean isPalidrome(ListNode head){
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNode = slow;
        ListNode firNode = midNode.next;
        midNode.next = null;
        ListNode cur = firNode.next;
        firNode.next = null;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = firNode;
            firNode = cur;
            cur = next;
        }
        slow = head;
        fast = firNode;
        while (slow != null && fast != null){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}