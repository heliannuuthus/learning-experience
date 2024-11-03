package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.MultiNode;
import java.util.*;

public class D11LevelOrder2 {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .levelOrder(MultiNode.build(new Integer[] {1, null, 3, 2, 4, null, 5, 6})));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(MultiNode root) {
            List<List<Integer>> result = new ArrayList<>();
            bfs(root, 0, result);
            return result;
        }

        private void bfs(MultiNode curr, int depth, List<List<Integer>> result) {
            if (curr == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(new ArrayList<>());
            }
            result.get(depth).add(curr.val);
            curr.children.forEach(child -> bfs(child, depth + 1, result));
        }
    }
}
