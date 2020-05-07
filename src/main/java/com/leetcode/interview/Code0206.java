package com.leetcode.interview;

import com.leetcode.mode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viruser on 2020/5/7.
 */
public class Code0206 {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(getExample()));
    }
    public static ListNode getExample(){
        ListNode node1 = new ListNode(-209);
        ListNode node2 = new ListNode(-209);
//        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(1);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        return node1;
    }

}

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(head.val);
        ListNode temp = head.next;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        System.out.println(list);
        return check(list);
    }

    public boolean check(List<Integer> value) {
        int maxIndex = value.size() -1 ;
        for (int i = 0 ; i < value.size()/2 ; i++) {
            if (value.get(i) - value.get(maxIndex - i) != 0) {
                return false;
            }
        }
        return true;
    }
}