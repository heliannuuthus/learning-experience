package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D11UniformTraversal {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .preOrderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    private static class Solution {
        public List<Integer> preOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    stack.push(node);
                    stack.push(null);
                } else {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
            return result;
        }

        public List<Integer> inOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    stack.push(node);
                    stack.push(null);
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                } else {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
            return result;
        }

        public List<Integer> postOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node != null) {
                    stack.push(node);
                    stack.push(null);
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                } else {
                    node = stack.pop();
                    result.add(node.val);
                }
            }
            return result;
        }
    }
}
