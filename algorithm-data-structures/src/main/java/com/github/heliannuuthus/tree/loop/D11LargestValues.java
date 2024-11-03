package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class D11LargestValues {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .largestValues(TreeNode.build(new Integer[] {1, 3, 2, 5, 3, null, 9})));
    }

    static class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                int max = Integer.MIN_VALUE;
                while (size-- > 0) {
                    TreeNode node = stack.removeFirst();
                    max = Math.max(max, node.val);
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
                result.add(max);
            }
            return result;
        }
    }
}
