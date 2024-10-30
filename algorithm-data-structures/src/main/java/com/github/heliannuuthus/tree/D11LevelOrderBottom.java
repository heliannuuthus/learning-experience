package com.github.heliannuuthus.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D11LevelOrderBottom {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrderBottom(
                                TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            List<List<Integer>> tmp = new ArrayList<>();
            if (root == null) {
                return tmp;
            }
            int level = 0;
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int length = stack.size();
                List<Integer> attrs = new ArrayList<>();
                while (length-- > 0) {
                    TreeNode node = stack.pollFirst();
                    attrs.add(node.val);
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
                tmp.add(level++, attrs);
            }
            List<List<Integer>> result = new ArrayList<>();
            for (int i = tmp.size() - 1; i >= 0; i--) {
                result.add(tmp.get(i));
            }
            return result;
        }
    }
}
