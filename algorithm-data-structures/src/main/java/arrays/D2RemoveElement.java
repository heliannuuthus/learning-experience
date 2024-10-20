package arrays;

public class D2RemoveElement {
    public static void main(String[] args) {

        System.out.println(new Solution().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));

    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0, j = 0;
            while (i < nums.length && j < nums.length) {
                while (j < nums.length && nums[j] == val) {
                   j++;
                }
                if (j == nums.length) {
                    break;
                }
                nums[i] = nums[j];
                i++;
                j++;
            }
            return i;
        }
    }
}