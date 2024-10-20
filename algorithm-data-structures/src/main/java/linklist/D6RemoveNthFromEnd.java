package linklist;

public class D6RemoveNthFromEnd {
    public static void main(String[] args) {
        System.out.println(new Solution().removeNthFromEnd(ListNode.build(new int[]{1, 2, 3,4}), 2));
    }


    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0),fast = dummy, slow = dummy;
            dummy.next = head;
            for (int i = 0; i <= n; i++) {
                fast = fast.next;
            }

            while (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
}
