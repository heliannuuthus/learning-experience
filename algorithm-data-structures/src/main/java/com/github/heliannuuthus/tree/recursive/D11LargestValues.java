package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
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
            bfs(root, 0, result);
            return result;
        }

        private void bfs(TreeNode curr, int depth, List<Integer> result) {
            if (curr == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(depth, curr.val);
            } else {
                result.set(depth, Math.max(result.get(depth), curr.val));
            }
            bfs(curr.left, depth + 1, result);
            bfs(curr.right, depth + 1, result);
        }
    }
}
