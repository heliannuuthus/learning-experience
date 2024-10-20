package linklist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    static ListNode build(int[] nums) {
        return chain(0, nums);
    }

    static ListNode chain(int idx, int[] nums) {
        if (idx == nums.length) {
            return null;
        }
        return new ListNode(nums[idx], chain(idx + 1, nums));
    }


    @Override
    public String toString() {
        return val + " -> " + next;
    }
}
