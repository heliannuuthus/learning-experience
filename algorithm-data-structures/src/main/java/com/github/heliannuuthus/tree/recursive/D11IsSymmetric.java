package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11IsSymmetric {

    public static void main(String[] args) {
        System.out.println(
                new Solution().isSymmetric(TreeNode.build(new Integer[] {1, 2, 2, 3, 4, 4, 3})));
    }

    private static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return compare(root.left, root.right);
        }

        private boolean compare(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            } else if (left != null && right == null) {
                return false;
            } else if (left == null) {
                return false;
            } else if (left.val != right.val) {
                return false;
            } else {
                boolean outside = compare(left.left, right.right);
                boolean inside = compare(left.right, right.left);
                return outside && inside;
            }
        }
    }
}
