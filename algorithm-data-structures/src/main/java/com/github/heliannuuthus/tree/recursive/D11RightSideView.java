package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class D11RightSideView {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .rightSideView(TreeNode.build(new Integer[] {1, 2, 3, null, 5, null, 4})));
    }

    static class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<>();
            bfs(root, 0, result);
            return result;
        }

        private void bfs(TreeNode curr, int depth, List<Integer> result) {
            if (curr == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(curr.val);
            }
            bfs(curr.right, depth + 1, result);
            bfs(curr.left, depth + 1, result);
        }
    }
}
