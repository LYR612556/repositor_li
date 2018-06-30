package com.coder.List;

import com.source.ListNode;

/**
 *环形单链表的约瑟夫问题
 * created by liyurong
 **/
public class SingleListJosephus {
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
        l8.next = l1;
        ListNode res = josephusKill(l1,3);
        System.out.println(res.val);
    }
    public static ListNode josephusKill(ListNode head,int m){
        if (head == null || head.next == head || m < 1) return head;
        ListNode last = head;
        while (last.next != head){//找到最后一个节点
            last = last.next;
        }
        int count = 0;
        while (head != last){//结束条件为只剩一个节点
            if (++ count == m){//删除喊到m的节点
                last.next = head.next;
                count = 0;
            }else {//向后遍历
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}