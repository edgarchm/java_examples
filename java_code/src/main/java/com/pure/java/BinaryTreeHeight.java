package com.pure.java;

class BinaryTreeHeight {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int binaryTreeHeight(TreeNode root) {
        // 1. If the root is null, return 0.
        if (root == null) {
            return 0;
        }

        // 2. Recursively calculate the height of the left subtree.
        int leftHeight = binaryTreeHeight(root.left);

        // 3. Recursively calculate the height of the right subtree.
        int rightHeight = binaryTreeHeight(root.right);

        // 4. Return the maximum of the left and right subtree heights, plus 1.
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Create a sample binary tree.
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode root2 = null;

        TreeNode root3 = new TreeNode(1);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.left.left = new TreeNode(3);
        root4.left.left.left = new TreeNode(4);

        TreeNode test[] = {root, root2, root3, root4};

        // Test cases.
        System.out.println("Test 1: " + binaryTreeHeight(test[0])); // Expected output: 3
        System.out.println("Test 2: " + binaryTreeHeight(test[1])); // Expected output: 0
        System.out.println("Test 3: " + binaryTreeHeight(test[2])); // Expected output: 1
        System.out.println("Test 4: " + binaryTreeHeight(test[3])); // Expected output: 4
    }
}
