package com.github.heliannuuthus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .inorderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    static class Solution {

        public List<Integer> inorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
            return result;
        }

        //        public List<Integer> inorderTraversal(TreeNode root) {
        //            List<Integer> result = new ArrayList<>();
        //            dfs(root, result);
        //            return result;
        //        }
        //
        //
        //        private void dfs(TreeNode current, List<Integer> result) {
        //            if (current == null) {
        //                return;
        //            }
        //            dfs(current.left, result);
        //            result.add(current.val);
        //            dfs(current.right, result);
        //        }
    }
}
