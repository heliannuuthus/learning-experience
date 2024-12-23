package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D13HasPathSum {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .hasPathSum(
                                TreeNode.build(
                                        new Integer[] {
                                            5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
                                        }),
                                22));
    }

    private static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null && targetSum - root.val == 0) {
                return true;
            }
            if (root.left != null && hasPathSum(root.left, targetSum - root.val)) {
                return true;
            }

            return root.right != null && hasPathSum(root.right, targetSum - root.val);
        }
    }
}
