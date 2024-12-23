package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class D12BinaryTreePaths {
    public static void main(String[] args) {
        System.out.println(
                new Solution().binaryTreePaths(TreeNode.build(new Integer[] {1, 2, 3, null, 5})));
    }

    private static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            if (root.left == null && root.right == null) {
                result.add(String.valueOf(root.val));
            }
            getPath(root.left, new StringBuilder().append(root.val), result);
            getPath(root.right, new StringBuilder().append(root.val), result);
            return result;
        }

        private void getPath(TreeNode curr, StringBuilder last, List<String> result) {
            if (curr == null) {
                return;
            }

            if (curr.left == null && curr.right == null) {
                result.add(last + "->" + curr.val);
            } else {
                last.append("->").append(curr.val);
            }
            getPath(curr.left, new StringBuilder(last), result);
            getPath(curr.right, new StringBuilder(last), result);
        }
    }
}
