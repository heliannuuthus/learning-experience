package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class D10PreorderTraversal {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .preorderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    private static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                if (curr != null) {
                    result.add(curr.val);
                    stack.push(curr);
                    curr = curr.left;
                } else {
                    curr = stack.pop();
                    curr = curr.right;
                }
            }
            return result;
        }

        //        public List<Integer> preorderTraversal(TreeNode root) {
        //            List<Integer> result = new ArrayList<>();
        //            dfs(root, result);
        //            return result;
        //        }
        //
        //        private void dfs(TreeNode current, List<Integer> result) {
        //            if (current == null) {
        //                return;
        //            }
        //            result.add(current.val);
        //            dfs(current.left, result);
        //            dfs(current.right, result);
        //        }
    }
}
