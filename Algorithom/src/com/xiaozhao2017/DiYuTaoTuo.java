package com.xiaozhao2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 网易2017——地狱逃脱，，，找最短路径里最长的一个，任意一个作为终点,获取最短路径的最大值，，，，bfs
 * created by liyurong
 **/
public class DiYuTaoTuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();//行
            int m = sc.nextInt();//列
            char[][] dungeon = new char[n][m];//迷宫
            for (int i = 0;i < n;i ++){
                String tmp = sc.next();
                dungeon[i] = tmp.toCharArray();
            }
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();//起点
            int k = sc.nextInt();//步长的个数
            int[][] dxy = new int[k][2];//步长
            for (int i = 0;i < k;i ++){
                dxy[i][0] = sc.nextInt();
                dxy[i][1] = sc.nextInt();
            }

            int maxDistance = bfs(dungeon,x0,y0,n,m,k,dxy);
            System.out.println(maxDistance);
        }
    }
    public static int bfs(char[][] dungeon,int x0,int y0,int n,int m,int k,int[][] dxy){
        int[][] distance = new int[n][m];//保存起点到终点的步长
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(x0);
        queueY.offer(y0);
        distance[x0][y0] = 1;

        while (! queueX.isEmpty() && ! queueY.isEmpty()){
            x0 = queueX.poll();
            y0 = queueY.poll();
            for (int i = 0;i < k;i ++){
                if (x0 + dxy[i][0] >= 0 && x0 + dxy[i][0] < n && y0 + dxy[i][1] >= 0 && y0 + dxy[i][1] < m){//判断是否越界
                    if (distance[x0 + dxy[i][0]][y0 + dxy[i][1]] == 0){//判断是否已经遍历过
                        if (dungeon[x0 + dxy[i][0]][y0 + dxy[i][1]] == '.'){//判断是否能通过
                            queueX.offer(x0 + dxy[i][0]);
                            queueY.offer(y0 + dxy[i][1]);
                            distance[x0 + dxy[i][0]][y0 + dxy[i][1]] = distance[x0][y0] + 1;//更新距离和队列
                        }else {
                            distance[x0 + dxy[i][0]][y0 + dxy[i][1]] = -1;
                        }
                    }
                }
            }
        }

        int maxDistance = 0;//最大最短路径
        int hasRoad = 1;//标识是否存在永远无法离开的节点
        for (int i = 0;i < n;i ++){
            for (int j = 0;j < m;j ++){
                if (distance[i][j] == 0 && dungeon[i][j] == '.'){
                    hasRoad = 0;
                }
                maxDistance = Math.max(maxDistance,distance[i][j]);
            }
        }
        if (hasRoad == 0){
            return -1;
        }else {
            return maxDistance - 1;
        }
    }
}