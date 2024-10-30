package com.github.heliannuuthus.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D11AverageOfLevels {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .averageOfLevels(
                                TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                double total = size;
                double sum = 0;
                while (size-- > 0) {
                    TreeNode node = stack.pollFirst();
                    sum += node.val;
                    if (size == 0) {
                        result.add(sum / total);
                    }
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
            }
            return result;
        }
    }
}
