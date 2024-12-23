package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.TreeNode;

public class D11MinDepth {
    public static void main(String[] args) {
        System.out.println(
                new Solution()
                        .minDepth(
                                TreeNode.build(
                                        new Integer[] {
                                            2, null, 3, null, null, null, 4, null, null, null, null,
                                            null, null, null, 5, null, null, null, null, null, null,
                                            null, null, null, null, null, null, null, null, null, 6,
                                        })));
    }

    private static class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null) {
                return 1;
            }
            int deep = Integer.MAX_VALUE;
            if (root.left != null) {
                deep = Math.min(deep, minDepth(root.left));
            }
            if (root.right != null) {
                deep = Math.min(deep, minDepth(root.right));
            }
            return deep + 1;
        }
    }
}
