package com.github.heliannuuthus.linklist;

public class D6ReverseList {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseList(ListNode.build(new int[]{1, 2, 3, 4, 5})));
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode listNode = reverseList(head, dummy);
            if (listNode == null) {
                return dummy.next;
            }
            listNode.next = null;
            return dummy.next;
        }

        public ListNode reverseList(ListNode head, ListNode dummy) {
            if (head == null ||  head.next == null) {
                dummy.next = head;
                return dummy;
            }
            ListNode current = reverseList(head.next, dummy);
            current.next = head;
            return head;
        }


    }
}
