package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D15GetMinimumDifference {

    public static void main(String[] args) {
        System.out.println(
                new Solution().getMinimumDifference(TreeNode.build(new Integer[] {4, 2, 6, 1, 3})));
    }

    private static class Solution {
        TreeNode pre = null;
        int min = Integer.MAX_VALUE;

        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return min;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);

            if (pre != null) {
                min = Math.min(min, root.val - pre.val);
            }
            pre = root;
            dfs(root.right);
        }
    }
}
