package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D11AverageOfLevels {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .averageOfLevels(
                                TreeNode.build(new Integer[] {3, 9, 20, null, null, 15, 7})));
    }

    static class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<double[]> tmp = new ArrayList<>();
            List<Double> result = new ArrayList<>();
            bfs(root, 0, tmp);
            for (double[] doubles : tmp) {
                result.add(doubles[0] / doubles[1]);
            }
            return result;
        }

        private void bfs(TreeNode curr, int depth, List<double[]> result) {
            if (curr == null) {
                return;
            }
            if (result.size() == depth) {
                result.add(depth, new double[] {0, 0});
            }
            double[] doubles = result.get(depth);
            doubles[0] += curr.val;
            doubles[1] += 1;
            bfs(curr.left, depth + 1, result);
            bfs(curr.right, depth + 1, result);
        }
    }
}
