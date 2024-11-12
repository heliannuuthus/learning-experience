package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D16ConvertBST {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .convertBST(
                                TreeNode.build(
                                        new Integer[] {
                                            4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null,
                                            null, 8
                                        })));
    }

    private static class Solution {
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            root.right = convertBST(root.right);
            sum += root.val;
            TreeNode curr = new TreeNode(sum);
            curr.right = root.right;
            root.left = convertBST(root.left);
            curr.left = root.left;
            return curr;
        }
    }
}
