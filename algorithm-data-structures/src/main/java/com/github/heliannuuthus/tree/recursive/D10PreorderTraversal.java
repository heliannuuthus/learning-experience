package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

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
            dfs(root, result);
            return result;
        }

        private void dfs(TreeNode curr, List<Integer> result) {
            if (curr == null) {
                return;
            }
            result.add(curr.val);
            dfs(curr.left, result);
            dfs(curr.right, result);
        }
    }
}
