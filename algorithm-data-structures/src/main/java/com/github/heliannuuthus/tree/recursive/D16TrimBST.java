package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D16TrimBST {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .trimBST(
                                TreeNode.build(new Integer[] {3, 0, 4, null, 2, null, null, 1}),
                                1,
                                3));
    }

    static class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            root.left = trimBST(root.left, low, high);
            if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            }
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
