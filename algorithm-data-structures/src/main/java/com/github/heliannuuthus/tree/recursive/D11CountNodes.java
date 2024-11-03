package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11CountNodes {
    public static void main(String[] args) {
        System.out.println(new Solution().countNodes(TreeNode.build(new Integer[] {1})));
    }

    static class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            TreeNode temp = root;
            int leftDepth = 0, rightDepth = 0;
            while (temp.left != null) {
                temp = temp.left;
                leftDepth++;
            }
            temp = root;
            while (temp.right != null) {
                temp = temp.right;
                rightDepth++;
            }

            if (leftDepth == rightDepth) {
                return (2 << leftDepth) - 1;
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
}
