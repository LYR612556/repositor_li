package com.xiaozhao2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 网易——混合颜料，数学问题，求矩阵的秩
 * created by liyurong
 **/
/**
 * 15
 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
 */
public class HunHeYanLiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            ArrayList<Integer> needs = new ArrayList<>();
            for (int i = 0;i < n;i ++){
                needs.add(sc.nextInt());
            }

            int minColor = getMinColor(needs);
            System.out.println(minColor);
        }
        sc.close();
    }
    //获取矩阵的秩
    public static int getMinColor(ArrayList<Integer> needs){
        int count = 0;
        Collections.sort(needs);
        //使用两个指针指向倒数两个数
        int end = needs.size() - 1;
        int secend = end - 1;
        while (needs.size() > 2){
            //若两者的最高位相同，说明可以消掉，将两者xor，或者说将矩阵两行相减消掉最高位
            if (getHighPosition(needs.get(end)) == getHighPosition(needs.get(secend))){
                //由于xor的是两个最大的数，并且最高位已经被消掉，所以xor得到的结果一定比这两个数小
                int tmp = needs.get(end) ^ needs.get(secend);
                if (! needs.contains(tmp)){
                    needs.add(tmp);
                    end ++;
                    secend ++;
                    Collections.sort(needs);
                }
            }else {
                //若两者的高位不同，说明所有数的最高位已经只有最大的那个数是1了，不可能被消掉，结果+1
                count ++;
            }
            //如果两个最大数的最高位可以消掉，那么消除之后，最大数已经被消掉没有用了
            //如果两个最大数的最高位不可以消掉，那么结果+1，最大数也没有用了
            //弹出最大数
            needs.remove(needs.size() - 1);
            //更新指针
            end = secend;
            secend --;
        }
        return needs.size() + count;
    }
    //求该数最高位是第几位
    public static int getHighPosition(int n){
        int count = 0;
        while (n != 0){
            n >>= 1;
            count ++;
        }
        return count;
    }
}