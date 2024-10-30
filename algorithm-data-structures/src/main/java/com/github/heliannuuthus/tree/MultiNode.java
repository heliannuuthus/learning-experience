package com.github.heliannuuthus.tree;

import java.util.*;

public class MultiNode {
    public int val;
    public List<MultiNode> children;

    public MultiNode() {}

    public MultiNode(int _val) {
        val = _val;
    }

    public MultiNode(int _val, List<MultiNode> _children) {
        val = _val;
        children = _children;
    }

    public static MultiNode build(Integer[] arr) {
        Deque<MultiNode> deque = new LinkedList<>();
        if (arr.length == 0) {
            return null;
        }
        MultiNode root = new MultiNode(arr[0], new ArrayList<>());
        deque.push(root);
        for (int i = 2; i < arr.length; i++) {
            int size = deque.size();
            while (size-- > 0) {
                MultiNode node = deque.pollFirst();
                while (i < arr.length && arr[i] != null) {
                    MultiNode curr = new MultiNode(arr[i++], new ArrayList<>());
                    node.children.add(curr);
                    deque.addLast(curr);
                }
            }
        }
        return root;
    }
}
