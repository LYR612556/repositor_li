package com.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * �����ǵ���Ϸ(ԲȦ�����ʣ�µ���)
 * ����λ�ã�https://my.oschina.net/liyurong/blog/1648777
 * created by liyurong
 **/
public class Niuke45_1 {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(6,3));
        System.out.println(LastRemaining_Solution(6,4));
    }
    public static int LastRemaining_Solution(int n, int m) {
        if (n == 0) return -1;//����Ҫ������һ���
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < n;i ++){
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1){
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}