package com.niuke;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 把数组排成最小的数，重载比较器
 * 排成最大的数：https://my.oschina.net/liyurong/blog/1570703
 * 本题博客：https://my.oschina.net/liyurong/blog/1635772
 * created by liyurong
 **/
public class Niuke33_1 {
    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
    public static String PrintMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] tmp = new String[numbers.length];
        for (int i = 0;i < numbers.length;i ++){
            tmp[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String ab = o1 + o2;
                String ba = o2 + o1;
                return ab.compareTo(ba);//按照字符串值降序排列
            }
        });
        for (int i = 0;i < tmp.length;i ++){
            sb.append(tmp[i]);
        }
        return sb.toString();
    }
}