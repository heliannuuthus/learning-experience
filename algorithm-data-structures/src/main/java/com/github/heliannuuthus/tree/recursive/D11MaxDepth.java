package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11MaxDepth {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .maxDepth(TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            return dfs(root, 0);
        }

        // 使用前序遍历
        private int dfs(TreeNode curr, int depth) {
            if (curr == null) {
                return 0;
            }
            int leftDepth = dfs(curr.left, depth) + 1;
            int rightDepth = dfs(curr.right, depth) + 1;
            return Math.max(leftDepth, rightDepth);
        }
    }
}
