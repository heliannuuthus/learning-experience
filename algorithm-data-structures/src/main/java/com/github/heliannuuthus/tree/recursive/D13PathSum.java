package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D13PathSum {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .pathSum(
                                TreeNode.build(
                                        new Integer[] {
                                            5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1
                                        }),
                                22));
    }

    private static class Solution {

        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            pathSum(root, targetSum, new ArrayList<>());
            return result;
        }

        private void pathSum(TreeNode root, int sum, List<Integer> tmp) {
            if (root == null) {
                return;
            }
            tmp.add(root.val);
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    result.add(new ArrayList<>(tmp));
                    return;
                }
            }
            if (root.left != null) {
                pathSum(root.left, sum - root.val, tmp);
                if (!tmp.isEmpty()) {
                    tmp.remove(tmp.size() - 1);
                }
            }
            if (root.right != null) {
                pathSum(root.right, sum - root.val, tmp);
                if (!tmp.isEmpty()) {
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}
