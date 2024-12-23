package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D11LevelOrderBottom {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrderBottom(
                                TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    private static class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            bfs(root, 0, result);
            return result;
        }

        private void bfs(TreeNode root, int depth, List<List<Integer>> result) {
            if (root == null) {
                return;
            }
            if (result.size() == depth) {
                ((LinkedList<List<Integer>>) result).addFirst(new ArrayList<>());
            }
            result.get(result.size() - depth - 1).add(root.val);
            bfs(root.left, depth + 1, result);
            bfs(root.right, depth + 1, result);
        }
    }
}
