package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D14ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        System.out.println(new Solution().constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5}));
    }

    private static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return split(nums, 0, nums.length);
        }

        private TreeNode split(int[] nums, int left, int right) {
            if (left == right) {
                return null;
            }
            if (right - left == 1) {
                return new TreeNode(nums[left]);
            }
            int maxIdx = -1, max = Integer.MIN_VALUE;
            for (int i = left; i < right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    maxIdx = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = split(nums, left, maxIdx);
            root.right = split(nums, maxIdx + 1, right);
            return root;
        }
    }
}
