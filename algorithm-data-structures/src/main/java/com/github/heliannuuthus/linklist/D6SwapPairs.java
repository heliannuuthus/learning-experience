package com.github.heliannuuthus.linklist;

public class D6SwapPairs {
    public static void main(String[] args) {
        System.out.println(new Solution().swapPairs(ListNode.build(new int[] {})));
    }

    private static class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode pre = null;
            ListNode curr = head;
            dummy.next = head.next;
            while (curr != null && curr.next != null) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = curr;
                if (pre != null) {
                    pre.next = next;
                }
                pre = curr;
                curr = curr.next;
            }
            return dummy.next;
        }
    }
}
