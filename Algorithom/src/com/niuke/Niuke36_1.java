package com.niuke;

/**
 * 数组中的逆序对,归并排序
 * 博客位置：https://my.oschina.net/liyurong/blog/1637804
 * created by liyurong
 **/
public class Niuke36_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,0};//7
        System.out.println(InversePairs(array));
        int[] arr = {7,5,6,4};//5
        System.out.println(InversePairs(arr));
    }
    public static int InversePairs(int [] array) {
        int count = divideSort(array,0,array.length - 1);
        return count;
    }
    public static int divideSort(int[] array,int start,int end){
        int count = 0;
        if (start < end){
            int mid = (end - start) / 2 + start;
            count += divideSort(array,start,mid) % 1000000007;
            count += divideSort(array,mid + 1,end) % 1000000007;
            count += merge(array,start,mid,end) % 1000000007;
        }
        return count % 1000000007;
    }
    public static int merge(int[] array,int start,int mid,int end){
        int[] tmp = new int[end - start + 1];
        int count = 0;
        if (start < end){
            int p = tmp.length - 1;
            int p1 = mid;
            int p2 = end;
            while (p1 >= start && p2 >= mid + 1){
                if (array[p1] > array[p2]){
                    count += p2 - mid;
                    count %= 1000000007;
                    tmp[p --] = array[p1 --];
                }else {
                    tmp[p --] = array[p2 --];
                }
            }
            while (p1 >= start){
                tmp[p --] = array[p1 --];
            }
            while (p2 >= mid + 1){
                tmp[p --] = array[p2 --];
            }
            for (int i = 0;i < tmp.length;i ++){
                array[start + i] = tmp[i];
            }
        }
        return count % 1000000007;
    }
}