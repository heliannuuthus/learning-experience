package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D16DeleteNode {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .deleteNode(TreeNode.build(new Integer[] {5, 3, 6, 2, 4, null, 7}), 3));
    }

    static class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            root.left = deleteNode(root.left, key);
            if (root.val == key) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode tmp = root.right;
                    while (tmp.left != null) {
                        tmp = tmp.left;
                    }
                    tmp.left = root.left;
                    return root.right;
                }
            }
            root.right = deleteNode(root.right, key);
            return root;
        }
    }
}
