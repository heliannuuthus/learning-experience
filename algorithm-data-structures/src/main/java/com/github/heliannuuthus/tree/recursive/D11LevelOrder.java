package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.*;

public class D11LevelOrder {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrder(TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            bfs(root, 0, result);
            return result;
        }

        private void bfs(TreeNode root, int depth, List<List<Integer>> result) {
            if (root == null) {
                return;
            }
            // 初始化
            if (result.size() == depth) {
                result.add(depth, new ArrayList<>());
            }
            result.get(depth).add(root.val);
            bfs(root.left, depth + 1, result);
            bfs(root.right, depth + 1, result);
        }
    }
}
