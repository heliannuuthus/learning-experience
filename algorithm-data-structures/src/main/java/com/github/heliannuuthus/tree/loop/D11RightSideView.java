package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D11RightSideView {
    public static void main(String[] args) {
        System.out.println(
                new Solution().rightSideView(TreeNode.build(new Integer[] {1, null, 3})));
    }

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<Integer> result = new LinkedList<>();
            if (root == null) {
                return result;
            }
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size-- > 0) {
                    TreeNode curr = stack.pollFirst();
                    if (size == 0) {
                        result.add(curr.val);
                    }
                    if (curr.left != null) {
                        stack.addLast(curr.left);
                    }
                    if (curr.right != null) {
                        stack.addLast(curr.right);
                    }
                }
            }
            return result;
        }
    }
}
