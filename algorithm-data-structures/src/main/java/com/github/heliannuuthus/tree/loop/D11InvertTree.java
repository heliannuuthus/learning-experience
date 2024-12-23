package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

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
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size-- > 0) {
                    TreeNode node = stack.pop();
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    TreeNode tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
            }
            return root;
        }
    }
}
