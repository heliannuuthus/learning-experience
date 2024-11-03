package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D10PostorderTraversal {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .postorderTraversal(
                                TreeNode.build(new Integer[] {1, null, 2, null, null, 3, null})));
    }

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            dfs(root, result);
            return result;
        }

        private void dfs(TreeNode curr, List<Integer> result) {
            if (curr == null) {
                return;
            }
            dfs(curr.left, result);
            dfs(curr.right, result);
            result.add(curr.val);
        }
    }
}
