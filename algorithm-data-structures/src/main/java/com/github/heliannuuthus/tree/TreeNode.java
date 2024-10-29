package com.github.heliannuuthus.tree;

import java.util.Objects;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(Integer[] arr) {
        return build(arr, 0);
    }

    public static TreeNode build(Integer[] arr, int idx) {
        if (idx >= arr.length) {
            return null;
        }
        TreeNode root = new TreeNode(arr[idx]);
        idx *= 2;
        if (idx + 1 < arr.length && Objects.nonNull(arr[idx + 1])) {
            root.left = build(arr, idx + 1);
        }
        if (idx + 2 < arr.length && Objects.nonNull(arr[idx + 2])) {
            root.right = build(arr, idx + 2);
        }
        return root;
    }
}
