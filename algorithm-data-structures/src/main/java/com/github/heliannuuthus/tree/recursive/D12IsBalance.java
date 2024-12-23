package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D12IsBalance {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .isBalanced(TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            } else if (root.left == null && root.right == null) {
                return true;
            }
            return Math.abs(depth(root.left) - depth(root.right)) <= 1
                    && isBalanced(root.left)
                    && isBalanced(root.right);
        }

        private int depth(TreeNode curr) {
            if (curr == null) {
                return 0;
            }
            if (curr.left == null && curr.right == null) {
                return 1;
            }
            return Math.max(depth(curr.left), depth(curr.right)) + 1;
        }
    }
}
