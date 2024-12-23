package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D14BuildTreePostAndInOrder {

    public static void main(String[] args) {
        System.out.println(new Solution().buildTree(new int[] {1, 2}, new int[] {2, 1}));
    }

    private static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return split(inorder, 0, inorder.length, postorder, 0, postorder.length);
        }

        private TreeNode split(
                int[] inorder,
                int inorderLeft,
                int inorderRight,
                int[] postorder,
                int postorderLeft,
                int postorderRight) {
            if (inorderLeft == inorderRight || postorderLeft == postorderRight) {
                return null;
            }

            if (inorderRight - inorderLeft == 1) {
                return new TreeNode(inorder[inorderLeft]);
            }

            TreeNode root = new TreeNode(postorder[postorderRight - 1]);

            int inorderSplitter = inorderLeft;
            while (inorderSplitter < inorderRight) {
                if (inorder[inorderSplitter] == root.val) {
                    break;
                }
                inorderSplitter++;
            }

            root.left =
                    split(
                            inorder,
                            inorderLeft,
                            inorderSplitter,
                            postorder,
                            postorderLeft,
                            postorderLeft + (inorderSplitter - inorderLeft));
            root.right =
                    split(
                            inorder,
                            inorderSplitter + 1,
                            inorderRight,
                            postorder,
                            postorderLeft + (inorderSplitter - inorderLeft),
                            postorderRight - 1);
            return root;
        }
    }
}
