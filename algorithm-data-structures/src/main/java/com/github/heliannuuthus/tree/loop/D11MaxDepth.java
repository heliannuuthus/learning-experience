package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

public class D11MaxDepth {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDepth(TreeNode.build(new Integer[] {1, null, 2})));
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int layer = 0;
            Deque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size-- > 0) {
                    if (size == 0) {
                        layer++;
                    }
                    TreeNode node = stack.removeFirst();
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
            }
            return layer;
        }
    }
}
