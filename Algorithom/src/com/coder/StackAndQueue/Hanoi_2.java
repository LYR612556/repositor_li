package com.coder.StackAndQueue;

import java.util.Stack;

/**
 * 汉诺塔问题，使用栈，非递归
 * created by liyurong
 **/
public class Hanoi_2 {
    public static void main(String[] args) {
        System.out.println(hanoiProblem2(2,"left","mid","right"));
    }
    public static int hanoiProblem2(int num,String left,String mid,String right){
        Stack<Integer> ls = new Stack<>();
        Stack<Integer> ms = new Stack<>();
        Stack<Integer> rs = new Stack<>();
        ls.push(Integer.MAX_VALUE);
        ms.push(Integer.MAX_VALUE);
        rs.push(Integer.MAX_VALUE);
        for (int i = num;i > 0;i --){//构造最左侧的汉诺塔
            ls.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rs.size() != num + 1){//结束条件,列举出所有情况
            step += fromStackToStack(record,Action.MToL,Action.LToM,ls,ms,left,mid);
            step += fromStackToStack(record,Action.LToM,Action.MToL,ms,ls,mid,left);
            step += fromStackToStack(record,Action.RToM,Action.MToR,ms,rs,mid,right);
            step += fromStackToStack(record,Action.MToR,Action.RToM,rs,ms,right,mid);
        }
        return step;
    }
    public static int fromStackToStack(Action[] record,Action preNoAct,Action nowAct,
                                       Stack<Integer> fromStack,Stack<Integer> toStack,
                                       String from,String to){
        if (record[0] != preNoAct && fromStack.peek() < toStack.peek()){//小压大原则
            toStack.push(fromStack.pop());
            System.out.println("Move " + toStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}