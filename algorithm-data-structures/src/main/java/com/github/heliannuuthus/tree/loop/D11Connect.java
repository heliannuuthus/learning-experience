package com.github.heliannuuthus.tree.loop;

import com.github.heliannuuthus.tree.Node;
import java.util.ArrayDeque;
import java.util.Deque;

public class D11Connect {
    public static void main(String[] args) {
        System.out.println(new Solution().connect(Node.build(new Integer[] {1, 2, 3, 4, 5, 6, 7})));
    }

    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> stack = new ArrayDeque<>();
            stack.addLast(root);
            while (!stack.isEmpty()) {
                int size = stack.size();
                while (size-- > 0) {
                    Node node = stack.removeFirst();
                    if (size == 0) {
                        node.next = null;
                    } else {
                        node.next = stack.peekFirst();
                    }
                    if (node.left != null) {
                        stack.addLast(node.left);
                    }
                    if (node.right != null) {
                        stack.addLast(node.right);
                    }
                }
            }
            return root;
        }
    }
}
