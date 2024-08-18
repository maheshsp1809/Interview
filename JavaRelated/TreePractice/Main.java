package TreePractice;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements u want in the tree");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < n; ++i) {
            tree.insert(arr[i]);
        }
        // System.out.println("Iterative preorder");
        // tree.ipreorder();

        System.out.println("Iterative inorder");
        tree.iinorder();

        // System.out.println("Iterative postorder");
        // tree.ipostorder();

        System.out.println("Inorder traversal");
        tree.inorder();
        // System.out.println();
        // System.out.println("Preorder traversal");
        // tree.preorder();
        System.out.println();
        // System.out.println("Postorder traversal");
        // tree.postorder();

    }
}
