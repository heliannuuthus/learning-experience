package com.github.heliannuuthus.tree;

import java.util.*;

public class D11LevelOrder {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrder(TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Deque<Object[]> queue = new ArrayDeque<>();
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            queue.push(new Object[] {root, 0});
            while (!queue.isEmpty()) {
                Object[] curr = queue.pollFirst();
                TreeNode node = (TreeNode) curr[0];
                int level = (Integer) curr[1];
                if (node != null) {
                    queue.addLast(new Object[] {node.left, level + 1});
                    queue.addLast(new Object[] {node.right, level + 1});
                    if (result.size() <= level) {
                        ArrayList<Integer> element = new ArrayList<>();
                        element.add(node.val);
                        result.add(level, element);
                    } else {
                        result.get(level).add(node.val);
                    }
                }
            }
            return result;
        }
    }
}
