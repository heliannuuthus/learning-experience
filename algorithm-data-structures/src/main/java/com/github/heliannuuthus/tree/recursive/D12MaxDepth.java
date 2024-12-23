package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.MultiNode;

public class D12MaxDepth {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .maxDepth(MultiNode.build(new Integer[] {1, null, 3, 2, 4, null, 5, 6})));
    }

    private static class Solution {
        public int maxDepth(MultiNode root) {
            if (root == null) {
                return 0;
            }
            if (root.children == null || root.children.isEmpty()) {
                return 1;
            }
            int max = Integer.MIN_VALUE;
            for (MultiNode child : root.children) {
                max = Math.max(maxDepth(child) + 1, max);
            }
            return max;
        }
    }
}
