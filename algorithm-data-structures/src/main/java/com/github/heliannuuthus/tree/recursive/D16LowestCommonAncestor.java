package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D16LowestCommonAncestor {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .lowestCommonAncestor(
                                TreeNode.build(
                                        new Integer[] {8, 10, 4, 1, 7, 15, 20, null, null, 6, 5}),
                                new TreeNode(5),
                                new TreeNode(10)));
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || p.val == root.val || q.val == root.val) {
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            } else if (left != null) {
                return left;
            } else return right;
        }
    }
}
