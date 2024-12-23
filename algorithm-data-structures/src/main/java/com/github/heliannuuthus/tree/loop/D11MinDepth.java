package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;

public class D11MinDepth {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .minDepth(
                                TreeNode.build(
                                        new Integer[] {
                                            2, null, 3, null, null, null, 4, null, null, null, null,
                                            null, null, null, 5, null, null, null, null, null, null,
                                            null, null, null, null, null, null, null, null, null, 6,
                                        })));
    }

    private static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int layer = 1;
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size-- > 0) {
                    TreeNode node = stack.removeFirst();
                    if (node.left == null && node.right == null) {
                        return layer;
                    }
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
                layer++;
            }
            return layer;
        }
    }
}
