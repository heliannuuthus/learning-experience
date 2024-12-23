package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D15FindMode {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution()
                                .findMode(
                                        TreeNode.build(
                                                new Integer[] {1, null, 2, null, null, 2}))));
    }

    private static class Solution {
        TreeNode pre = null;
        int count = 1, maxCount = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            dfs(root);
            return result.stream().mapToInt(i -> i).toArray();
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                if (pre.val == root.val) {
                    count++;
                } else {
                    count = 1;
                }
            }
            if (count == maxCount) {
                result.add(root.val);
            } else if (count > maxCount) {
                maxCount = count;
                result.clear();
                result.add(root.val);
            }
            pre = root;
            dfs(root.right);
        }
    }
}
