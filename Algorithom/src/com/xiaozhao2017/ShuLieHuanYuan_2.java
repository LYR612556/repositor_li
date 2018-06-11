package com.xiaozhao2017;

import java.util.*;

/**
 * 网易——数列还原
 * 使用交换方法获取全排列
 * created by liyurong
 **/
public class ShuLieHuanYuan_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] A = new int[n];
            boolean[] isOccur = new boolean[n + 1];
            for (int i = 0;i < n;i ++){
                A[i] = sc.nextInt();
                if (A[i] != 0){
                    isOccur[A[i]] = true;
                }
            }

            List<Integer> isNotOccur = new ArrayList<>();
            for (int i = 1;i <= n;i ++){
                if (! isOccur[i]){
                    isNotOccur.add(i);
                }
            }

            List<List<Integer>> permutations = new ArrayList<>();
            getPermutations(permutations,isNotOccur,0);

            int count = 0;
            for (int i = 0;i < n;i ++){
                if (A[i] != 0){
                    for (int j = i + 1;j < n;j ++){
                        if (A[j] != 0 && A[i] < A[j]){
                            count ++;
                        }
                    }
                }
            }

            int res = 0;
            for (List<Integer> list : permutations){
                int val = count;
                int[] tmpA = Arrays.copyOf(A,n);
                val += getValue(list,tmpA);
                if (val == k){
                    res ++;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }

    public static int getValue(List<Integer> isNotOccur,int[] A){
        int value = 0;
        int index = 0;
        for (int i = 0;i < A.length;i ++){
            if (A[i] == 0){
                A[i] = isNotOccur.get(index ++);
                for (int k = 0;k < i;k ++){
                    if (A[k] != 0 && A[k] < A[i]){
                        value ++;
                    }
                }
                for (int k = i + 1;k < A.length;k ++){
                    if (A[k] != 0 && A[k] > A[i]){
                        value ++;
                    }
                }
            }
        }
        return value;
    }

    public static void getPermutations(List<List<Integer>> permutations,List<Integer> isNotOccur,int i){
        if (i == isNotOccur.size()){
            permutations.add(new ArrayList<>(isNotOccur));
        }else {
            for (int j = i;j < isNotOccur.size();j ++){
                Collections.swap(isNotOccur,j,i);
                getPermutations(permutations,isNotOccur,i + 1);
                Collections.swap(isNotOccur,j,i);
            }
        }
    }
}