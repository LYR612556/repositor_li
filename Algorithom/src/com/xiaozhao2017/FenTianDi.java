package com.xiaozhao2017;

import java.util.Scanner;

/**
 * 网易——分田地,竖切枚举+二分查找,又是一个。。。题
 * created by liyurong
 **/
public class FenTianDi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] fields = new int[n][m];
            for (int i = 0;i < n;i ++){
                char[] tmp = sc.next().toCharArray();
                for (int j = 0;j < m;j ++){
                    fields[i][j] = tmp[j] - '0';
                }
            }

            int[][] sum = new int[n + 1][m + 1];//从fields[0][0]到fields[i - 1][j - 1]的和
            for (int i = 1;i <= n;i ++){
                for (int j = 1;j <= m;j ++){
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + fields[i - 1][j - 1];
                }
            }

            //二分查找最小面积行
            int left = 0;
            int right = sum[n][m];//最小面积的初始取值范围为[0,sum]
            int res = 0;
            while (left <= right){
                int mid = (right - left) / 2 + left;//假定为最小面积，进行判断
                if (judge(mid,n,m,sum)){//mid是最小面积
                    left = mid + 1;
                    res = mid;
                }else {
                    right = mid - 1;
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
    //判断x是否小于等于竖切之后田地中最小的一块的值
    public static boolean judge(int x,int n,int m,int[][] sum){
        for (int i = 1;i <= m - 3;i ++){
            for (int j = i + 1;j <= m - 2;j ++){
                for (int k = j + 1;k <= m - 1;k ++){
                    int lastRow = 0;//上一个划分的最后一行
                    int count = 0;//比x面积大的个数
                    for (int row = 1;row <= n;row ++){//row,i表示田地的右下角，lastRow，..，表示田地的右上角
                        int sum1 = cal(row,i,lastRow,0,sum);
                        int sum2 = cal(row,j,lastRow,i,sum);
                        int sum3 = cal(row,k,lastRow,j,sum);
                        int sum4 = cal(row,m,lastRow,k,sum);
                        if (sum1 >= x && sum2 >= x && sum3 >= x && sum4 >= x){
                            lastRow = row;
                            count ++;
                        }
                    }
                    if (count >= 4){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int cal(int x,int y,int i,int j,int[][] sum){
        return sum[x][y] - sum[i][y] - sum[x][j] + sum[i][j];
    }
}