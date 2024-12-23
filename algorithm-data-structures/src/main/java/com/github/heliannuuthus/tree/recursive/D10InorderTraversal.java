package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D10InorderTraversal {

    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .inorderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    private static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, result);
            return result;
        }

        private void dfs(TreeNode node, List<Integer> result) {
            if (node == null) {
                return;
            }
            dfs(node.left, result);
            result.add(node.val);
            dfs(node.right, result);
        }
    }
}
