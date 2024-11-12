package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D16SortedArrayToBST {
    public static void main(String[] args) {
        System.out.println(new Solution().sortedArrayToBST(new int[] {0, 1, 2, 3, 4, 5}));
    }

    private static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return recursive(nums, 0, nums.length);
        }

        private TreeNode recursive(int[] nums, int start, int end) {
            if (start >= end) {
                return null;
            }
            if (end - start == 1) {
                return new TreeNode(nums[start]);
            }
            int leftEnd = (end - start - 1) / 2;
            TreeNode root = new TreeNode(nums[start + leftEnd]);
            root.left = recursive(nums, start, start + leftEnd);
            root.right = recursive(nums, start + leftEnd + 1, end);
            return root;
        }
    }
}
