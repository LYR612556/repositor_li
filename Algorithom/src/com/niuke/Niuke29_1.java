package com.niuke;

/**
 * 数组中出现次数超过一半的数字,根据数组特点，数组中超过一半的数，肯定比其余所有数加起来多
 * 博客位置：https://my.oschina.net/liyurong/blog/915707，其中的推举法存在问题，应使用本题的解法
 * 数组中大于n/3的数：https://my.oschina.net/liyurong/blog/1591542
 * created by liyurong
 **/
public class Niuke29_1 {
    public static void main(String[] args){
        //int[] numbers = {1,2,3,2,4,2,5,2,3};//0
        //int[] numbers = {1,2,3,2,4,2,5,2,2};//2
        int[] numbers = {4,2,4,1,4,2};//0
        int res = MoreThanHalfNum_Solution(numbers);
        System.out.println(res);
    }
    public static int MoreThanHalfNum_Solution(int [] array) {
        int majority = 0;
        int count = 0;
        for (int i = 0;i < array.length;i ++){
            if (count == 0){
                majority = array[i];
                count ++;
            }else if (array[i] == majority){
                count ++;
            }else {
                count --;
            }
        }
        //判断是否数量超过一半
        count = 0;
        for (int i = 0;i < array.length;i ++){
            if (array[i] == majority){
                count ++;
            }
        }
        if (count <= array.length / 2){
            return 0;
        }
        return majority;
    }
}
