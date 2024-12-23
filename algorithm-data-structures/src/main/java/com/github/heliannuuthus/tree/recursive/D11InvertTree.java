package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11InvertTree {

    public static void main(String[] args) {
        System.out.println(
                new Solution().invertTree(TreeNode.build(new Integer[] {4, 2, 7, 1, 3, 6, 9})));
    }

    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
}
