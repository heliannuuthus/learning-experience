package com.github.heliannuuthus.linklist;

public class D7IntersectionNode {

    public static void main(String[] args) {
        System.out.println(new Solution().getIntersectionNode(
                ListNode.build(new int[]{4, 1, 8, 4, 5}),
                ListNode.build(new int[]{5, 0, 1, 8, 4, 5})));
    }

    static class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            ListNode current = headA;
            int lengthA = 0, lengthB = 0;
            while (current != null) {
                current = current.next;
                lengthA++;
            }

            current = headB;
            while (current != null) {
                current = current.next;
                lengthB++;
            }

            while (lengthA > lengthB) {
                headA = headA.next;
                lengthA--;
            }

            while (lengthB > lengthA) {
                headB = headB.next;
                lengthB--;
            }

            if (headA == headB) return headA;

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
                if (headA == null || headB == null) return null;
            }

            return headA;
        }

    }

}
