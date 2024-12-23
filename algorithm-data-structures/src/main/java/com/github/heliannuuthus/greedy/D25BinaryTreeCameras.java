package com.github.heliannuuthus.greedy;

import com.github.heliannuuthus.tree.TreeNode;

public class D25BinaryTreeCameras {

    private static class Solution {
        int result = 0;

        public int minCameraCover(TreeNode root) {
            if (dfs(root) == 0) {
                return ++result;
            }
            return result;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 2;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            // return 1 需要安装摄像头
            // return 2 当前节点被覆盖
            // return 0 当前节点无覆盖
            // 左右节点都没有覆盖，当前节点需要覆盖
            if ((left == 0 || right == 0)) {
                result++;
                return 1;
            }
            if (left == 2 && right == 2) {
                return 0;
            }
            // 左右节点其中一个安了摄像头，当前的节点应该是被覆盖
            if (left == 1 || right == 1) {
                return 2;
            }
            return -1;
        }
    }
}
