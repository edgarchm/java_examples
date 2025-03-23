package com.pure.java;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeInvert {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void preorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        // Constructing a sample binary tree:
        //      4
        //    /   \
        //   2     7
        //  / \   / \
        // 1   3 6   9

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        BinaryTreeInvert inverter = new BinaryTreeInvert();
        TreeNode invertedRoot = inverter.invertTree(root);

        System.out.println("Original Tree (Preorder):");
        preorderTraversal(root);
        System.out.println();

        System.out.println("Inverted Tree (Preorder):");
        preorderTraversal(invertedRoot);
        System.out.println();

        System.out.println("Original Tree (Inorder):");
        inorderTraversal(root);
        System.out.println();

        System.out.println("Inverted Tree (Inorder):");
        inorderTraversal(invertedRoot);
        System.out.println();

        System.out.println("Original Tree (Postorder):");
        postorderTraversal(root);
        System.out.println();

        System.out.println("Inverted Tree (Postorder):");
        postorderTraversal(invertedRoot);
        System.out.println();
    }
}