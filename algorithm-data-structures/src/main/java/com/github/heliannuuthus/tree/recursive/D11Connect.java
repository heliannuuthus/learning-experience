package com.github.heliannuuthus.tree.recursive;

import com.github.heliannuuthus.tree.Node;
import java.util.ArrayList;
import java.util.List;

public class D11Connect {
    public static void main(String[] args) {
        System.out.println(new Solution().connect(Node.build(new Integer[] {1, 2, 3, 4, 5, 6, 7})));
    }

    static class Solution {
        public Node connect(Node root) {
            List<Node> last = new ArrayList<>();
            bfs(root, 0, last);
            return root;
        }

        private void bfs(Node curr, int depth, List<Node> last) {
            if (curr == null) {
                return;
            }
            if (last.size() == depth) {
                last.add(depth, curr);
            } else {
                last.set(depth, last.get(depth).next = curr);
            }
            bfs(curr.left, depth + 1, last);
            bfs(curr.right, depth + 1, last);
        }
    }
}
