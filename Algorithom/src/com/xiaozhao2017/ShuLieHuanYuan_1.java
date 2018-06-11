package com.xiaozhao2017;

import java.util.*;

/**
 * 网易——数列还原
 * 使用标记数组获取全排列
 * created by liyurong
 **/
public class ShuLieHuanYuan_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];
            boolean[] isOccur = new boolean[n + 1];//用于标识未出现的数字
            for (int i = 0;i < n;i ++){
                A[i] = sc.nextInt();
                if (A[i] != 0){
                    isOccur[A[i]] = true;
                }
            }

            List<Integer> isNotOccur = new ArrayList<>();//保存未出现的数字
            for (int i = 1;i <= n;i ++){
                if (! isOccur[i]){
                    isNotOccur.add(i);
                }
            }

            int count = 0;//统计模糊数组中顺序对的个数
            for (int i = 0;i < n;i ++){
                if (A[i] != 0){
                    for (int j = i + 1;j < n;j ++){
                        if (A[j] != 0 && A[i] < A[j]){
                            count ++;
                        }
                    }
                }
            }

            //获取未出现数字的全排列
            List<List<Integer>> permutations = new ArrayList<>();
            List<Integer> list = new ArrayList<>();//用于保存中间数组
            boolean[] isused = new boolean[isNotOccur.size()];
            getPermutations(isNotOccur,isused,list,permutations);

            int res = 0;
            //统计所未出现数字和已出现数字的顺序对,并计算总的顺序对
            for (List<Integer> tmp : permutations){
                int val = count;
                int[] tmpA = Arrays.copyOf(A,n);
                val += getVal(tmp,tmpA);
                if (val == k){
                    res ++;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }

    public static int getVal(List<Integer> list,int[] A){
        int val = 0;
        int index = 0;
        for (int i = 0;i < A.length;i ++){
            if (A[i] == 0){
                A[i] = list.get(index ++);
                for (int k = 0;k < i;k ++){
                    if (A[k] != 0 && A[k] < A[i]){
                        val ++;
                    }
                }
                for (int k = i + 1;k < A.length;k ++){
                    if (A[k] != 0 && A[k] > A[i]){
                        val ++;
                    }
                }
            }
        }
        return val;
    }

    public static void getPermutations(List<Integer> isNotOccur,boolean[] isused,List<Integer> list,List<List<Integer>> permutations){
        if (list.size() == isNotOccur.size()){
            permutations.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0;i < isNotOccur.size();i ++){
            if (! isused[i]){
                isused[i] = true;
                list.add(isNotOccur.get(i));
                getPermutations(isNotOccur,isused,list,permutations);
                list.remove(list.size() - 1);
                isused[i] = false;
            }
        }
    }
}