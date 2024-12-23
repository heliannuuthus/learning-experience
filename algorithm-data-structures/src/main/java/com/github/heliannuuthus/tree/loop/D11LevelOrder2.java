package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.MultiNode;
import java.util.ArrayList;
import java.util.List;

public class D11LevelOrder2 {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrder(MultiNode.build(new Integer[] {1, null, 3, 2, 4, null, 5, 6})));
    }

    private static class Solution {
        public List<List<Integer>> levelOrder(MultiNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<MultiNode> stack = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                List<Integer> eachLayer = new ArrayList<>();
                List<MultiNode> next = new ArrayList<>();
                for (MultiNode node : stack) {
                    eachLayer.add(node.val);
                    next.addAll(node.children);
                }
                stack = next;
                result.add(eachLayer);
            }
            return result;
        }
    }
}
