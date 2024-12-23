package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11CountNodes {
    public static void main(String[] args) {
        System.out.println(new Solution().countNodes(TreeNode.build(new Integer[] {1})));
    }

    private static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = 1, rightDepth = 1;
            TreeNode tmp = root.left;
            while (tmp != null) {
                tmp = tmp.left;
                leftDepth++;
            }
            tmp = root.right;
            while (tmp != null) {
                tmp = tmp.right;
                rightDepth++;
            }
            if (leftDepth == rightDepth) {
                return (int) (Math.pow(2, leftDepth) - 1);
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
