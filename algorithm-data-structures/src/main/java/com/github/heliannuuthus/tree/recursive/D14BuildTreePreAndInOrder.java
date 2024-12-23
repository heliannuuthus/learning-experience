package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D14BuildTreePreAndInOrder {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .buildTree(
                                new int[] {3, 9, 14, 12, 20, 15, 7},
                                new int[] {14, 9, 12, 3, 15, 20, 7}));
    }

    private static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return split(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode split(
                int[] preorder,
                int preorderLeft,
                int preorderRight,
                int[] inorder,
                int inorderLeft,
                int inorderRight) {
            if (preorderLeft == preorderRight || inorderLeft == inorderRight) {
                return null;
            }

            if (inorderRight - inorderLeft == 1) {
                return new TreeNode(inorder[inorderLeft]);
            }

            TreeNode root = new TreeNode(preorder[preorderLeft]);

            int inorderSplitter = inorderLeft;
            while (inorderSplitter < inorderRight) {
                if (root.val == inorder[inorderSplitter]) {
                    break;
                }
                inorderSplitter++;
            }
            preorderLeft += 1;
            root.left =
                    split(
                            preorder,
                            preorderLeft,
                            preorderLeft + (inorderSplitter - inorderLeft),
                            inorder,
                            inorderLeft,
                            inorderSplitter);
            root.right =
                    split(
                            preorder,
                            preorderLeft + (inorderSplitter - inorderLeft),
                            preorderRight,
                            inorder,
                            inorderSplitter + 1,
                            inorderRight);
            return root;
        }
    }
}
