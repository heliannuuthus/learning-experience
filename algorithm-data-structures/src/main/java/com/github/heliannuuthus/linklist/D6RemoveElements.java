package com.github.heliannuuthus.linklist;

public class D6RemoveElements {

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            // 去掉头部
            while (head != null && head.val == val) {
                head = head.next;
            }

            ListNode current = head, prev = head;

            // 遍历剩下
            while (current != null) {
                if (current.val == val) {
                    prev.next = current.next;
                } else {
                    prev = current;
                }
                current = current.next;
            }
            return head;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElements(ListNode.build(new int[]{1, 2, 2, 1}), 2));
    }
}
