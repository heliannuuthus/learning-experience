package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D13FindBottomLeftValue {
    public static void main(String[] args) {
        System.out.println(new Solution().findBottomLeftValue(TreeNode.build(new Integer[] {0})));
    }

    static class Solution {

        private static int result = 0;
        private static int maxDepth = -1;

        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 0);
            return result;
        }

        private int dfs(TreeNode curr, int depth) {
            if (curr == null) {
                return depth;
            }
            if (depth > maxDepth) {
                maxDepth = depth;
                result = curr.val;
            }
            depth++;
            depth = dfs(curr.left, depth);
            depth--;
            depth++;
            depth = dfs(curr.right, depth);
            depth--;
            return depth;
        }
    }
}
