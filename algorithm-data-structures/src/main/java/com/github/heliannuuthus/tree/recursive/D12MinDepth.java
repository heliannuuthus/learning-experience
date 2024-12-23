package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D12MinDepth {
    public static void main(String[] args) {}

    private static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            } else if (root.left == null) {
                return minDepth(root.right) + 1;
            } else if (root.right == null) {
                return minDepth(root.left) + 1;
            } else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
