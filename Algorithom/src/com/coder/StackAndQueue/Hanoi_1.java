package com.coder.StackAndQueue;

/**
 * 汉诺塔问题，递归解决
 * created by liyurong
 **/
public class Hanoi_1 {
    public static void main(String[] args) {
        System.out.println(hanoiProblem1(2,"left","mid","right"));
    }
    public static int hanoiProblem1(int num,String left,String mid,String right){
        if (num < 1) return 0;
        return process(num,left,mid,right,left,right);
    }
    public static int process(int num,String left,String mid,String right,
                              String from,String to){
        if (num == 1){//递归结束条件
            if (from.equals(mid) || to.equals(mid)){
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            }else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)){//经过中间,三个步骤
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1,left,mid,right,from,another);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1,left,mid,right,another,to);
            return part1 + part2 + part3;
        }else {//从左至右，五个步骤
            int part1 = process(num - 1,left,mid,right,from,to);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + mid);
            int part3 = process(num - 1,left,mid,right,to,from);
            int part4 = 1;
            System.out.println("Move " + num + " from " + mid + " to " + to);
            int part5 = process(num - 1,left,mid,right,from,to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}