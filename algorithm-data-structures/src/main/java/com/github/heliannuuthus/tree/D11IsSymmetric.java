package com.github.heliannuuthus.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class D11IsSymmetric {

    public static void main(String[] args) {
        System.out.println(
                new Solution().isSymmetric(TreeNode.build(new Integer[] {1, 2, 2, 3, 4, 4, 3})));
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            boolean isSymmetric = true;
            if (root == null) {
                return isSymmetric;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                Deque<TreeNode> temp = new LinkedList<>();
                while (size-- > 0) {
                    TreeNode node = stack.pop();
                    temp.push(node.left);
                    temp.push(node.right);
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
                isSymmetric = temp.isEmpty();
                while (!temp.isEmpty()) {
                    TreeNode left = temp.removeFirst();
                    TreeNode right = temp.removeLast();
                    if (Objects.isNull(left) && Objects.isNull(right)) {
                        isSymmetric = true;
                    } else if (Objects.nonNull(left) && Objects.nonNull(right)) {
                        isSymmetric = left.val == right.val;
                    } else {
                        isSymmetric = false;
                    }
                    if (!isSymmetric) {
                        return isSymmetric;
                    }
                }
            }
            return isSymmetric;
        }
    }
}
