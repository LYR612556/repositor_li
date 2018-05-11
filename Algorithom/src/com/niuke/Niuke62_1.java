package com.niuke;

import com.source.TreeNode;

/**
 * ���л���������ʹ����ͬ�ı�����ʽ����ֵ�����⴦��
 **/
public class Niuke62_1 {
    /**
     * �����������ĵ�k���ڵ㣬���������k��
     **/
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(Serialize(t1));
        System.out.println(Deserialize(Serialize(t1)).val);
        }
    public static String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null){
            sb.append("$,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    private static int index = -1;
    public static TreeNode Deserialize(String str) {//��Ҫע����ǣ�����static�ؼ��ֵ����˿�ָ���쳣�������ύʱ����ȥ��static
        index ++;
        int len = str.length();
        if (index >= len){
            return null;
        }
        String[] schar = str.split(",");
        TreeNode root = null;
        if (! schar[index].equals("$")){
            root = new TreeNode(Integer.valueOf(schar[index]));
            root.left = Deserialize(str);
            root.right = Deserialize(str);
        }
        return root;
    }
}