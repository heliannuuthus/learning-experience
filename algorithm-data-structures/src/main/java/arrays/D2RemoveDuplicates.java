package arrays;

public class D2RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 2, 3,4, 5}));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0, j = i + 1;
            while (i < nums.length && j < nums.length) {
                while (j < nums.length && nums[i] == nums[j]) {
                    j++;
                }
                if (j == nums.length) {
                    return i + 1;
                }
                nums[++i] = nums[j++];
            }
            return i + 1;
        }
    }
}
