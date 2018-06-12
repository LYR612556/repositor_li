package com.coder.List;

import com.source.ListNode;

/**
 * 反转部分单链表，需要加一些判断
 * created by liyurong
 **/
public class ReversePartList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        ListNode cur = l1;
        System.out.println("反转之前： ");
        while (cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        System.out.println("反转之后： ");
        ListNode res = reversePart(l1,1,5);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
    public static ListNode reversePart(ListNode head,int from,int to){
        int len = 0;
        ListNode node1 = head;
        ListNode fpre = null;
        ListNode tpos = null;
        while (node1 != null){//在计算链表长度的过程中找到要反转链表的前一个节点和后一个节点
            len ++;
            fpre = len == from - 1 ? node1 : fpre;
            tpos = len == to + 1 ? node1 : tpos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) return head;
        node1 = fpre == null ? head : fpre.next;//指向要反转链表的第一个节点
        ListNode node2 = node1.next;//移动指针
        node1.next = tpos;
        ListNode next = null;
        while (node2 != tpos){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fpre != null){//不是从头节点开始反转
            fpre.next = node1;
            return head;
        }
        return node1;//从头节点开始反转
    }
}