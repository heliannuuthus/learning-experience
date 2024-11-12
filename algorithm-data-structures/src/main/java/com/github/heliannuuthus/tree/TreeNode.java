package com.github.heliannuuthus.tree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    // 无参构造器
    TreeNode() {}

    // 带值构造器
    public TreeNode(int val) {
        this.val = val;
    }

    // 带值及左右子节点构造器
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // 根据数组构建二叉树
    public static TreeNode build(Integer[] arr) {
        return build(arr, 0);
    }

    // 根据数组和当前索引递归构建二叉树
    private static TreeNode build(Integer[] arr, int idx) {
        if (idx >= arr.length || arr[idx] == null) {
            return null;
        }

        // 当前节点
        TreeNode root = new TreeNode(arr[idx]);

        // 左子节点索引：2 * idx + 1
        root.left = build(arr, 2 * idx + 1);
        // 右子节点索引：2 * idx + 2
        root.right = build(arr, 2 * idx + 2);

        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(this, sb, 0);
        return sb.toString();
    }

    // 辅助方法：格式化打印树
    private void printTree(TreeNode node, StringBuilder sb, int level) {
        if (node == null) {
            // 在每一层的空节点上进行打印
            appendIndented(sb, level).append("null\n");
            return;
        }

        // 打印当前节点
        appendIndented(sb, level).append(node.val).append("\n");

        // 打印左子树和右子树
        printTree(node.left, sb, level + 1);
        printTree(node.right, sb, level + 1);
    }

    // 辅助方法：在每一层添加适当的缩进
    private StringBuilder appendIndented(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) {
            sb.append("    "); // 使用4个空格来表示缩进
        }
        return sb;
    }
}
