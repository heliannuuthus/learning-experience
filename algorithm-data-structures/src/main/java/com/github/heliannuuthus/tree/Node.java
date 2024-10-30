package com.github.heliannuuthus.tree;

import java.util.Objects;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node build(Integer[] arr) {
        return build(arr, 0);
    }

    public static Node build(Integer[] arr, int idx) {
        if (idx >= arr.length) {
            return null;
        }
        Node root = new Node(arr[idx]);
        idx *= 2;
        if (idx + 1 < arr.length && Objects.nonNull(arr[idx + 1])) {
            root.left = build(arr, idx + 1);
        }
        if (idx + 2 < arr.length && Objects.nonNull(arr[idx + 2])) {
            root.right = build(arr, idx + 2);
        }
        return root;
    }

    @Override
    public String toString() {
        return "{" + val + " < " + left + " > " + right + " v " + next + "}";
    }
}
;
