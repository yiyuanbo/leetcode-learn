package com.leetcode.service;

import com.leetcode.mode.TreeNode;

/**
 * Created by viruser on 2020/5/7.
 * 给定两个非空二叉树 s 和 t，
 * 检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
 * s 也可以看做它自身的一棵子树。
 */
public class LeetCode572 {
    public static void main(String[] args) {
        System.out.println(new Solution().isSubtree(getExample(),getExample2()));
    }

    public static TreeNode getExample(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node4;
        node3.right = node5;
        node4.left = node1;
        node4.right = node2;
        node2.right = new TreeNode(0);
        return node3;
    }

    public static TreeNode getExample2(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node4.left = node1;
        node4.right = node2;
        return node4;
    }

    static class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (isEqual(s, t)) {
                return true;
            }
            boolean status = false;
            if (s.left != null) {
                status = status || isSubtree(s.left, t);
            }
            if (s.right != null) {
                status = status || isSubtree(s.right, t);
            }
            return status;
        }

        public boolean isEqual(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }else if (s == null || t == null){
                return false;
            }
            if (s.val == t.val) {
                return isEqual(s.left, t.left) && isEqual(s.right, t.right);
            }else {
                return false;
            }
        }
    }


}

