package com.xiaozhao2017;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * ����2017�����������ѣ����������·�������һ��������һ����Ϊ�յ�,��ȡ���·�������ֵ��������bfs
 * created by liyurong
 **/
public class DiYuTaoTuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();//��
            int m = sc.nextInt();//��
            char[][] dungeon = new char[n][m];//�Թ�
            for (int i = 0;i < n;i ++){
                String tmp = sc.next();
                dungeon[i] = tmp.toCharArray();
            }
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();//���
            int k = sc.nextInt();//�����ĸ���
            int[][] dxy = new int[k][2];//����
            for (int i = 0;i < k;i ++){
                dxy[i][0] = sc.nextInt();
                dxy[i][1] = sc.nextInt();
            }

            int maxDistance = bfs(dungeon,x0,y0,n,m,k,dxy);
            System.out.println(maxDistance);
        }
    }
    public static int bfs(char[][] dungeon,int x0,int y0,int n,int m,int k,int[][] dxy){
        int[][] distance = new int[n][m];//������㵽�յ�Ĳ���
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        queueX.offer(x0);
        queueY.offer(y0);
        distance[x0][y0] = 1;

        while (! queueX.isEmpty() && ! queueY.isEmpty()){
            x0 = queueX.poll();
            y0 = queueY.poll();
            for (int i = 0;i < k;i ++){
                if (x0 + dxy[i][0] >= 0 && x0 + dxy[i][0] < n && y0 + dxy[i][1] >= 0 && y0 + dxy[i][1] < m){//�ж��Ƿ�Խ��
                    if (distance[x0 + dxy[i][0]][y0 + dxy[i][1]] == 0){//�ж��Ƿ��Ѿ�������
                        if (dungeon[x0 + dxy[i][0]][y0 + dxy[i][1]] == '.'){//�ж��Ƿ���ͨ��
                            queueX.offer(x0 + dxy[i][0]);
                            queueY.offer(y0 + dxy[i][1]);
                            distance[x0 + dxy[i][0]][y0 + dxy[i][1]] = distance[x0][y0] + 1;//���¾���Ͷ���
                        }else {
                            distance[x0 + dxy[i][0]][y0 + dxy[i][1]] = -1;
                        }
                    }
                }
            }
        }

        int maxDistance = 0;//������·��
        int hasRoad = 1;//��ʶ�Ƿ������Զ�޷��뿪�Ľڵ�
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