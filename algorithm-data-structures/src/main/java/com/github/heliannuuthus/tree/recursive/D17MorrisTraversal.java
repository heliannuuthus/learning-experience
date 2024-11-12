package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D17MorrisTraversal {
    public static void main(String[] args) {
        new Solution().morrisTraversal(TreeNode.build(new Integer[] {4, 2, 6, 1, 3, 5, 7}));
    }

    private static class Solution {
        public void morrisTraversal(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode tmp = curr.left;
                    while (tmp.right != null && tmp.right != curr) {
                        tmp = tmp.right;
                    }
                    if (tmp.right == null) {
                        tmp.right = curr;
                        curr = curr.left;
                    } else {
                        tmp.right = null;
                        System.out.println(curr.val);
                        curr = curr.right;
                    }
                } else {
                    System.out.println(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}
