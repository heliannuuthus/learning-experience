package com.github.heliannuuthus.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D10PostorderTraversal {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .postorderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            TreeNode curr = root, last = null;
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    if (curr.right != null && curr.right != last) {
                        stack.push(curr);
                        last = curr;
                        curr = curr.right;
                    } else {
                        result.add(curr.val);
                        last = curr;
                        curr = null;
                    }
                }
            }
            return result;
        }

        //        public List<Integer> postorderTraversal(TreeNode root) {
        //            List<Integer> result = new ArrayList<>();
        //            dfs(root, result);
        //            return result;
        //        }
        //
        //        private void dfs(TreeNode current, List<Integer> result) {
        //            if (current == null) {
        //                return;
        //            }
        //            dfs(current.left, result);
        //            dfs(current.right, result);
        //            result.add(current.val);
        //        }
    }
}
