package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class D12IsBalanced {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .isBalanced(TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                if (Math.abs(getDepth(node.left) - getDepth(node.right)) > 1) {
                    return false;
                }
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
            return true;
        }

        public int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            int depth = 0;
            int result = 0;
            while (!stack.isEmpty()) {
                TreeNode node = stack.removeLast();
                if (node != null) {
                    stack.addLast(node);
                    stack.addLast(null);
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    depth++;
                } else {
                    stack.removeLast();
                    depth--;
                }
                result = Math.max(result, depth);
            }
            return result;
        }
    }
}
