package com.niuke;

import com.source.RandomListNode;

/**
 * 复杂链表的复制，另一种方法是借助辅助的map
 * 博客位置：https://my.oschina.net/liyurong/blog/1545380
 * created by liyurong
 **/
public class Niuke26_1 {
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = pHead;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = pHead;
        RandomListNode head = pHead.next;
        while (cur != null){
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            if (tmp.next != null){
                tmp.next = tmp.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}