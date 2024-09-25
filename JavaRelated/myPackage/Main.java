package myPackage;

import myPackage.*;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Perform inorder traversal
        System.out.println("Inorder traversal of the binary tree:");
        tree.inorderTraversal();
    }
}
