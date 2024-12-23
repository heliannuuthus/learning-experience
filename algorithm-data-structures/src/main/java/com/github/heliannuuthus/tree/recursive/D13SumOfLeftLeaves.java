package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D13SumOfLeftLeaves {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .sumOfLeftLeaves(
                                TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            return dfs(root, false, 0);
        }

        private int dfs(TreeNode curr, boolean isLeft, int sum) {
            if (curr == null) {
                return sum;
            }
            if (curr.left == null && curr.right == null && isLeft) {
                sum += curr.val;
            }
            sum = dfs(curr.left, true, sum);
            sum = dfs(curr.right, false, sum);
            return sum;
        }
    }
}
